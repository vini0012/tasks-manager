package com.taskmanager.taskmanager.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import com.taskmanager.taskmanager.dto.UserDto;
import com.taskmanager.taskmanager.entity.User;
import com.taskmanager.taskmanager.exception.UserNotFoundException;
import com.taskmanager.taskmanager.repository.UserRepository;
import com.taskmanager.taskmanager.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public record UserServiceImpl(UserRepository repository) implements UserService {

    @Override
    public User createUser(UserDto userDto) {
        var user = new User();

        BeanUtils.copyProperties(userDto, user);

        user.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        user.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserById(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new UserNotFoundException("User not found: " + uuid));
    }
}
