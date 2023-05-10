package org.example.LR8.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UserResponse(
        Integer id,
        String middleName,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        Boolean sex,
        String passportNumber,
        String identityNumber,
        List<TownResponse> townList,
        String address,
        String homePhoneNumber,
        String phoneNumber,
        Boolean conscripted
) {
}