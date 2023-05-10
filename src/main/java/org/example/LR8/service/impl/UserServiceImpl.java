package org.example.LR8.service.impl;

import org.example.LR8.dto.mapper.UserMapper;
import org.example.LR8.dto.request.UserRequest;
import org.example.LR8.dto.response.UserResponse;
import org.example.LR8.entity.User;
import org.example.LR8.exception.type.BusinessException;
import org.example.LR8.repository.UserRepository;
import org.example.LR8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = userRepository.save(userMapper.toUser(userRequest));
        return userMapper.toResponseDto(user);
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        userRepository.findById(userRequest.getId())
                .ifPresentOrElse((user) -> {
                            userRepository.save(userMapper.toUser(userRequest));
                        },
                        () -> {
                            throw new BusinessException(
                                    String.format("User with id: %s not found", userRequest.getId()),
                                    HttpStatus.NOT_FOUND);
                        });
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id)
                .ifPresentOrElse((user) -> {
                            userRepository.deleteById(user.getId());
                        },
                        () -> {
                            throw new BusinessException(
                                    String.format("User with id: %s not found", id),
                                    HttpStatus.NOT_FOUND);
                        });
    }

    @Override
    public UserResponse getUserById(Integer id) {
        return userMapper.toResponseDto(getUser(id));
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponseDto)
                .toList();
    }


    private User getUser(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        String.format("User with id: %s not found", id),
                        HttpStatus.NOT_FOUND));
    }
}