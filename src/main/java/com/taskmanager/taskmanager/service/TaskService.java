package com.taskmanager.taskmanager.service;

import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.enumeration.TaskStatus;

public interface TaskService {

    Task createTask(TaskDto taskDto);
    String deleteTask(UUID uuid);
    Task updateTask(UUID uuid, TaskStatus status, String description);
    String markAsCompleted(UUID uuid);
    Task findById(UUID uuid);
    List<Task> findByUserId(UUID userId);
    List<Task> listTasks();
    List<Task> listTaskByStatus(TaskStatus status);
}
