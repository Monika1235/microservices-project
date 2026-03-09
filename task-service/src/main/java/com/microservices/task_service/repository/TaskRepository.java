package com.microservices.task_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservices.task_service.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>{

}