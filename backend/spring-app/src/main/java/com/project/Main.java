package com.project;

import com.project.domain.auth.BaseEntity;
import com.project.usecase.auth.SaveBaseEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final SaveBaseEntity saveBaseEntity;
    private final PasswordEncoder passwordEncoder;

    public Main(SaveBaseEntity saveBaseEntity, PasswordEncoder passwordEncoder) {
        this.saveBaseEntity = saveBaseEntity;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args)  {
        saveBaseEntity.save(new BaseEntity("test", passwordEncoder.encode("test")));
    }
}
