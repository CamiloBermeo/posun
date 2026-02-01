package com.posun.infrastructure.controller;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.domain.useCase.tenant.ICreateTenantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tenants")
@RequiredArgsConstructor
public class TenantController {
    private final ICreateTenantUseCase createTenantUseCase;

    @PostMapping
    public ResponseEntity<CreateTenantResponseDTO> createTenant(@RequestBody CreateTenantRequestDTO createTenantRequestDTO) {
        CreateTenantResponseDTO responseDTO = createTenantUseCase.execute(createTenantRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
