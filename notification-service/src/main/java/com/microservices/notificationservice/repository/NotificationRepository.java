package com.microservices.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.notificationservice.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{

}
