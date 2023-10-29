package com.taskmanager.taskmanager.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.TaskDto;
import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.enumeration.TaskStatus;
import com.taskmanager.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.taskmanager.repository.TaskRepository;
import com.taskmanager.taskmanager.service.TaskService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        var task = new Task();

        BeanUtils.copyProperties(taskDto, task);

        task.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        task.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return repository.save(task);
    }

    @Override
    @Transactional
    public String deleteTask(UUID uuid) {
        Task task = repository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("Task not found."));
        repository.delete(task);
        return "Task deleted successfully.";
    }

    @Override
    public Task updateTask(UUID uuid, TaskStatus status, String description) {
        return repository.findById(uuid)
                .map(task -> {
                    task.setStatus(status);
                    task.setDescription(description);
                    task.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
                    return repository.save(task);
                }).orElseThrow(() -> new TaskNotFoundException("Task not found."));
    }

    @Override
    public String markAsCompleted(UUID uuid) {
        Task task = repository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("Task not found."));
        task.setStatus(TaskStatus.COMPLETED);
        task.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        repository.save(task);
        return "Task marked as completed.";
    }

    @Override
    public Task findById(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new TaskNotFoundException("Task not found: " + uuid));
    }

    @Override
    public List<Task> findByUserId(UUID userId) {
        return repository.findTasksByUserId(userId);
    }

    @Override
    public List<Task> listTasks() {
        return repository.findAll();
    }

    @Override
    public List<Task> listTaskByStatus(TaskStatus status) {
        return repository.findTasksByStatus(status);
    }
}
