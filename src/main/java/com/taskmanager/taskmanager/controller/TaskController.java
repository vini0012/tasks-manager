package com.taskmanager.taskmanager.controller;

import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.enumeration.TaskStatus;
import com.taskmanager.taskmanager.service.TaskService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public record TaskController(TaskService service) {

    @MutationMapping
    public Task createTask(@Valid @Argument TaskDto taskDto) {
        return service.createTask(taskDto);
    }

    @MutationMapping
    public String deleteTask(@Argument UUID uuid) {
        return service.deleteTask(uuid);
    }

    @MutationMapping
    public Task updateTask(@Argument UUID uuid, @Argument TaskStatus status, @Argument String description) {
        return service.updateTask(uuid, status, description);
    }

    @MutationMapping
    public String markAsCompleted(@Argument UUID uuid) {
        return service.markAsCompleted(uuid);
    }

    @QueryMapping
    public Task findTaskById(@Argument UUID uuid) {
        return service.findById(uuid);
    }

    @QueryMapping
    public List<Task> findTasksByUserId(@Argument UUID userId) {
        return service.findByUserId(userId);
    }

    @QueryMapping
    public List<Task> findAllTasks() {
        return service.listTasks();
    }

    @QueryMapping
    public List<Task> findTaskByStatus(@Argument TaskStatus status) {
        return service.listTaskByStatus(status);
    }

}