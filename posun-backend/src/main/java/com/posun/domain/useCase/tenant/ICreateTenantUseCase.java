package com.posun.domain.useCase.tenant;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;

public interface ICreateTenantUseCase {
    CreateTenantResponseDTO execute (CreateTenantRequestDTO createTenantRequestDTO);
}
