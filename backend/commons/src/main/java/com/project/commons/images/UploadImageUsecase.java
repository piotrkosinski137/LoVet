package com.project.commons.images;

import static com.project.commons.errors.ErrorCode.E_DEFAULT;
import static com.project.commons.errors.ErrorCode.E_GENERAL_01;
import static com.project.commons.errors.ErrorCode.E_GENERAL_02;
import static com.project.commons.errors.ErrorCode.E_GENERAL_03;
import static com.project.commons.errors.ErrorCode.E_GENERAL_04;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Set;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class UploadImageUsecase {

  @Value("${images.path}")
  private String filesPathUri;
  @Value("${images.types.allowed}")
  private Set<String> allowedMimeTypes;

  @PostConstruct
  public void createDirectory() {
    try {
      Files.createDirectories(Paths.get(filesPathUri));
    } catch (IOException e) {
      throw new ImageSaveFailed(E_DEFAULT, "Error during creating images base directory");
    }
  }

  public String upload(String base64Image, String path) {
    if (base64Image == null) {
      return null;
    }

    validateMimeType(base64Image);
    byte[] decodedImg = Base64.getDecoder()
        .decode(base64Image.split(",")[1].getBytes(StandardCharsets.UTF_8));
    validateImageSize(decodedImg);

    String imageName = UUID.randomUUID().toString();
    Path destinationFile = Paths.get(filesPathUri + path, imageName + ".png");
    try {
      Files.write(destinationFile, decodedImg, StandardOpenOption.CREATE);
    } catch (IOException e) {
      throw new ImageSaveFailed(E_GENERAL_03);
    }
    return path + imageName + ".png";
  }

  public Resource downloadImage(String imagePath) throws MalformedURLException {
    File localFile = new File(filesPathUri + imagePath);
    if (!localFile.exists()) {
      throw new ImageReadFailed(E_GENERAL_04);
    }
    return new UrlResource("file", localFile.getPath());
  }

  private void validateImageSize(byte[] decodedImg) {
    if (decodedImg.length > 5000000) {
      throw new ImageSaveFailed(E_GENERAL_02, "Too big image size: %s" + decodedImg.length);
    }
  }

  private void validateMimeType(String image) {
    String mimeType = image.split(",")[0];
    if (allowedMimeTypes.stream().anyMatch(allowedType -> allowedType.contains(mimeType))) {
      throw new ImageSaveFailed(E_GENERAL_01);
    }
  }
}
