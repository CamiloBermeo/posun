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
    private final FindTenantByNameUseCase findTenantByNameUseCase;


    public CreateTenantResponseDTO createTenant(CreateTenantRequestDTO dto) {
        String encodePassword = passwordEncoder.encode(dto.userAdminRequestDTO().password());
        UserAdmin userAdmin = UserAdminAppMapper.toModel(dto.userAdminRequestDTO(), encodePassword);
        Tenant tenant = TenantAppMapper.toModel(dto, userAdmin);
        //verificar que el tenant no exista
        Tenant tenantDb = findTenantByNameUseCase.execute(tenant.getBusinessName().getValue());
        Tenant tenantRepository = repository.createTenant(tenant);

        return TenantAppMapper.toDTO(tenantRepository);
    }
}
