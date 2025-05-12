package com.guesthousemanagement.guesthousemanagementsystem.service;

import com.guesthousemanagement.guesthousemanagementsystem.dto.user.UserResponse;
import com.guesthousemanagement.guesthousemanagementsystem.entity.user.User;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse addUser(User user);

    UserResponse getUserById(long userId);

    void deleteUser(User user);

    UserResponse updateUser(User user);
}
