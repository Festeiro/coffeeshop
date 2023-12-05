package com.example.coffeeshop.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class ImageFilesResources {
    @Value("${products.img.path}")
    private String imgsPath;

    public FileSystemResource findInFileSystem(String imgName) {
        try {
            String fullPath =  getImgsPath() + imgName;
            return new FileSystemResource(Paths.get(fullPath));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public String getImgsPath() {
        return imgsPath;
    }
}
