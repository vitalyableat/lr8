package org.example.LR8.dto.mapper;

import org.example.LR8.dto.request.TownRequest;
import org.example.LR8.dto.response.TownResponse;
import org.example.LR8.entity.Town;
import org.example.LR8.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TownMapper {
    public TownResponse toResponseDto(Town town) {
        return TownResponse.builder()
                .town(town.getTown())
                .id(town.getId())
                .build();
    }

    public Town toTown(TownRequest townRequest, User user) {
        return Town.builder()
                .user(user)
                .town(townRequest.getTown())
                .build();
    }
}