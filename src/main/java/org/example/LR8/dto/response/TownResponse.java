package org.example.LR8.dto.response;

import lombok.Builder;

@Builder
public record TownResponse(
        Integer id,
        String town
) {
}