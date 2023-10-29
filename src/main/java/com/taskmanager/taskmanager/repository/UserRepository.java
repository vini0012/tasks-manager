package com.taskmanager.taskmanager.repository;

import java.util.UUID;

import com.taskmanager.taskmanager.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
}
