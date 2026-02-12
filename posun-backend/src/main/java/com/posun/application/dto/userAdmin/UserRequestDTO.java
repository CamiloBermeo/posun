package com.posun.application.dto.userAdmin;

public record UserRequestDTO(
        String name,
        String lastName,
        String userPosition,
        String phoneNumber,
        String email,
        String password
) {
}
