package org.example.LR8.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String middleName;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean sex;
    private String passportNumber;
    private String identityNumber;
    private String address;
    private String homePhoneNumber;
    private String phoneNumber;
    private Boolean conscripted;
}