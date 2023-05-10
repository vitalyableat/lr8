package org.example.LR8.service;

import org.example.LR8.dto.request.TownRequest;
import org.example.LR8.dto.response.TownResponse;

public interface TownService {
    TownResponse addTown(Integer userId, TownRequest townRequest);
}