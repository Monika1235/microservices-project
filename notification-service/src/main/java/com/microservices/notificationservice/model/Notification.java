package com.microservices.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;

    private String message;

    private String service;

}
