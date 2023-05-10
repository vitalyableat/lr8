package org.example.LR8.service;

import org.example.LR8.dto.request.UserRequest;
import org.example.LR8.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);

    void deleteUser(Integer id);

    UserResponse getUserById(Integer id);

    List<UserResponse> getAll();
}