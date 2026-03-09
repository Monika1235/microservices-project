package com.microservices.task_service.dto;

import lombok.Data;

@Data
public class Notification {

    private String id;
    private String message;
    private String service;

}
