package com.microservices.task_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import com.microservices.task_service.dto.Notification;
import com.microservices.task_service.dto.User;
import com.microservices.task_service.model.Task;
import com.microservices.task_service.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Task createTask(@RequestBody Task task) {

        String url = "http://user-service:8080/users/" + task.getUserId();
        String notificationUrl = "http://notification-service:8080/notifications";
        
        User user = restTemplate.getForObject(url, User.class);

        System.out.println("Task assigned to user: " + user.getName());

        // Save task
        Task savedTask = taskRepository.save(task);

        // Send notification
        Notification notification = new Notification();
        notification.setMessage("Task created: " + task.getTitle());
        notification.setService("task-service");

        restTemplate.postForObject(notificationUrl, notification, Notification.class);

        return savedTask;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

}
