package com.microservices.fileservice.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.microservices.fileservice.dto.Notification;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class FileService {

    @Autowired
    private S3Client s3Client;

    @Autowired
    private RestTemplate restTemplate;
    
    private final String bucketName = "microservices-file-storage-moni";

    public String uploadFile(MultipartFile file) throws IOException {

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(file.getOriginalFilename())
                .build();
        s3Client.putObject(
                request,
                software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes())
        );

        String notificationUrl = "http://notification-service:8080/notifications";

        Notification notification = new Notification();
        notification.setMessage("File uploaded: " + file.getOriginalFilename());
        notification.setService("file-service");

        restTemplate.postForObject(notificationUrl, notification, Notification.class);

        return "File uploaded successfully";

    }
}
