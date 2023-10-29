package com.taskmanager.taskmanager.repository;

import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.enumeration.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findTasksByUserId(UUID userId);
    List<Task> findTasksByStatus(TaskStatus status);

}
