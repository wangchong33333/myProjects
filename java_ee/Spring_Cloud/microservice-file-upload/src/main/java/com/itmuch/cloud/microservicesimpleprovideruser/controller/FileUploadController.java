package com.itmuch.cloud.microservicesimpleprovideruser.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String fileUpload(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(fileBytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }
}