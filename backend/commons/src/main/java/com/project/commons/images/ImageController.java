package com.project.commons.images;

import java.net.MalformedURLException;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lovet-images")
public class ImageController {

  private final UploadImageUsecase uploadImageUsecase;

  public ImageController(UploadImageUsecase uploadImageUsecase) {
    this.uploadImageUsecase = uploadImageUsecase;
  }

  @GetMapping(value = "/pets/{imageName}")
  public ResponseEntity<Resource> downloadAttachment(@PathVariable String imageName) throws MalformedURLException {
    Resource file = uploadImageUsecase.downloadImage("pets/" + imageName);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file
            .getFilename() + "\"")
        .body(file);
  }
}
