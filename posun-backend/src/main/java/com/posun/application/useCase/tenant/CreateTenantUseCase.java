package com.posun.application.useCase.tenant;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.application.mapper.TenantAppMapper;
import com.posun.application.mapper.UserAdminAppMapper;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.repository.ITenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateTenantUseCase {
    private final ITenantRepository repository;
    private final PasswordEncoder passwordEncoder;


    public CreateTenantResponseDTO createTenant(CreateTenantRequestDTO createTenantRequestDTO) {
        String encodePassword = passwordEncoder.encode(createTenantRequestDTO.userAdminRequestDTO().password());

        UserAdmin userAdmin = UserAdminAppMapper.toModel(createTenantRequestDTO.userAdminRequestDTO(), encodePassword);
        Tenant tenant = TenantAppMapper.toModel(createTenantRequestDTO, userAdmin);
        Tenant tenantRepository = repository.createTenant(tenant);

        return TenantAppMapper.toDTO(tenantRepository);
    }
}
