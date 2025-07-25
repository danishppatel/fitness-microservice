package com.fitness.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserResponse {
    private String id;

    private  String email;

    private  String password;

    private  String firstName;

    private  String lastName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
