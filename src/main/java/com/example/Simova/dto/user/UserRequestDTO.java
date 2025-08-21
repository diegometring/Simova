package com.example.Simova.dto.user;

import java.time.LocalDateTime;

public record UserRequestDTO(String firstName,
                             String lastName,
                             String email,
                             String password,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt
                             ) {
}
