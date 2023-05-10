package org.example.LR8.service.impl;

import org.example.LR8.dto.mapper.TownMapper;
import org.example.LR8.dto.request.TownRequest;
import org.example.LR8.dto.response.TownResponse;
import org.example.LR8.entity.Town;
import org.example.LR8.entity.User;
import org.example.LR8.exception.type.BusinessException;
import org.example.LR8.repository.TownRepository;
import org.example.LR8.repository.UserRepository;
import org.example.LR8.service.TownService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final UserRepository userRepository;
    private final TownMapper townMapper;

    @Override
    public TownResponse addTown(Integer userId, TownRequest townRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(
                        String.format("User with id: %s not found", userId),
                        HttpStatus.NOT_FOUND));
        Town town = townMapper.toTown(townRequest, user);
        return townMapper.toResponseDto(townRepository.save(town));
    }
}