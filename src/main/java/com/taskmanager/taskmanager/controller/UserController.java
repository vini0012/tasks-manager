package com.taskmanager.taskmanager.controller;

import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.UserDto;
import com.taskmanager.taskmanager.entity.User;
import com.taskmanager.taskmanager.service.UserService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public record UserController(UserService service) {

    @MutationMapping
    public User createUser(@Valid @Argument UserDto userDto) {
        return service.createUser(userDto);
    }

    @QueryMapping
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @QueryMapping
    public User findUserById(@Argument UUID uuid) {
        return service.findUserById(uuid);
    }

}