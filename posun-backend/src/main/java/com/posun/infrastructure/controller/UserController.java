package com.posun.infrastructure.controller;

import com.posun.application.dto.userAdmin.UserAdminRequestDTO;
import com.posun.application.dto.userAdmin.UserAdminResponseDTO;
import com.posun.application.useCase.users.NewUserAdminUseCase;
import com.posun.infrastructure.security.CustomUserDetails;
import com.posun.infrastructure.security.SecurityUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final NewUserAdminUseCase newUserAdminUseCase;

    //debo sacar info que ya tenga el user logueado que me permita obtener info del tenant para buscarlo y asociar este usuario con el tenant
    @PostMapping("/admins")
    public ResponseEntity<UserAdminResponseDTO> newUserAdmin (@RequestBody UserAdminRequestDTO dto, @AuthenticationPrincipal UserDetails currentUser){
        CustomUserDetails principal = (CustomUserDetails) currentUser;
        Long tenantId = principal.tenantId();
        UserAdminResponseDTO responseDTO = newUserAdminUseCase.execute(dto, tenantId);
        return ResponseEntity.ok(responseDTO);
    }
}
