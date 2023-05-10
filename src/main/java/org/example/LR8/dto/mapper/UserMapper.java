package org.example.LR8.dto.mapper;

import org.example.LR8.dto.request.UserRequest;
import org.example.LR8.dto.response.UserResponse;
import org.example.LR8.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final TownMapper townMapper;

    public UserResponse toResponseDto(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .passportNumber(user.getPassportNumber())
                .phoneNumber(user.getPhoneNumber())
                .sex(user.getSex())
                .conscripted(user.getConscripted())
                .homePhoneNumber(user.getHomePhoneNumber())
                .address(user.getAddress())
                .build();
    }

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .firstName(userRequest.getFirstName())
                .middleName(userRequest.getMiddleName())
                .lastName(userRequest.getLastName())
                .dateOfBirth(userRequest.getDateOfBirth())
                .passportNumber(userRequest.getPassportNumber())
                .phoneNumber(userRequest.getPhoneNumber())
                .sex(userRequest.getSex())
                .conscripted(userRequest.getConscripted())
                .homePhoneNumber(userRequest.getHomePhoneNumber())
                .address(userRequest.getAddress())
                .build();
    }
}