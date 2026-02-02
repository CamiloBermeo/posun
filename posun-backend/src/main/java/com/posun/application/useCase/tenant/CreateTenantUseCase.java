package com.posun.application.useCase.tenant;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.application.mapper.TenantAppMapper;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.TenantConfig;
import com.posun.domain.repository.ITenantRepository;
import com.posun.domain.useCase.tenant.ICreateTenantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTenantUseCase implements ICreateTenantUseCase {
    private final ITenantRepository repository;

    @Override
    public CreateTenantResponseDTO execute(CreateTenantRequestDTO createTenantRequestDTO) {
        Tenant tenant = TenantAppMapper.toModel(createTenantRequestDTO);
        Tenant tenantRepository = repository.createTenant(tenant);

        return TenantAppMapper.toDTO(tenantRepository);
    }
}
