package org.example.LR8.controller;

import org.example.LR8.dto.request.TownRequest;
import org.example.LR8.service.TownService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/towns")
public class TownController {
    private final TownService townService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{userId}")
    public void addTown(@RequestBody TownRequest townRequest,
                        @PathVariable Integer userId) {
        townService.addTown(userId, townRequest);
    }

}