package com.microservices.fileservice.dto;

import lombok.Data;

@Data
public class Notification {

    private String id;
    private String message;
    private String service;

}
