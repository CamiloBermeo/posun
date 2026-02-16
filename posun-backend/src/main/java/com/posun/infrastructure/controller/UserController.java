package com.posun.infrastructure.controller;

import com.posun.application.dto.userAdmin.UserRequestDTO;
import com.posun.application.dto.userAdmin.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/admins")
    public ResponseEntity<UserResponseDTO> newUserAdmin (@RequestBody UserRequestDTO dto){


    }
}
