package com.microservices.fileservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.fileservice.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        return fileService.uploadFile(file);

    }

}
