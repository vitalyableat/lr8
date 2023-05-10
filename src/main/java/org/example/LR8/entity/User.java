package org.example.LR8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String middleName;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean sex;
    private String passportNumber;
    private String identityNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Town> townList;
    private String address;
    private String homePhoneNumber;
    private String phoneNumber;
    private Boolean conscripted;

    @PrePersist
    private void init() {
        dateOfBirth = LocalDate.now();
    }
}
