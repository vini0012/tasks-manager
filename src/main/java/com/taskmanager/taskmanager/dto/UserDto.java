package com.taskmanager.taskmanager.dto;

import java.util.UUID;

import com.taskmanager.taskmanager.enumeration.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank String username,
        @NotNull String fullName,
        @NotBlank String email)
{}
