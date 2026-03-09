package com.microservices.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservices.notificationservice.model.Notification;
import com.microservices.notificationservice.repository.NotificationRepository;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){

        return notificationRepository.save(notification);
    }
    
    @GetMapping
    public List<Notification> getNotifications(){
        return notificationRepository.findAll();
    }

}
