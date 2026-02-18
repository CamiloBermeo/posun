package com.posun.application.dto.userAdmin;

import java.time.LocalDateTime;

public record UserAdminResponseDTO (
    Long id,
    String email,
    String name,
    String lastName,
    String userPosition,
    boolean status
){
}
