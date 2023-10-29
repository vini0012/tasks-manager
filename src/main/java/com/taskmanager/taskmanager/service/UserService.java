package com.taskmanager.taskmanager.service;

import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.UserDto;
import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.entity.User;

public interface UserService {

    User createUser(UserDto userDto);
    List<User> findAllUsers();
    User findUserById(UUID uuid);
}
