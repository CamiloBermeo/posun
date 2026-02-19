package com.posun.application.useCase.tenant;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.application.exception.tenant.TenantIsPresentException;
import com.posun.application.mapper.TenantAppMapper;
import com.posun.application.mapper.UserAdminAppMapper;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.repository.ITenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateTenantUseCase {
    private final ITenantRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final FindTenantByNameUseCase findTenantByNameUseCase;


    public CreateTenantResponseDTO createTenant(CreateTenantRequestDTO dto) {
        String encodePassword = passwordEncoder.encode(dto.userAdminRequestDTO().password());
        //verificar que el tenant no exista
        Optional<Tenant> tenantDb = findTenantByNameUseCase.execute(dto.businessName());

        if (tenantDb.isPresent()) {
            throw new TenantIsPresentException(dto.businessName());
        }else {
            UserAdmin userAdmin = UserAdminAppMapper.toModel(dto.userAdminRequestDTO(), encodePassword);
            Tenant tenant = TenantAppMapper.toModel(dto, userAdmin);

            Tenant tenantRepository = repository.createTenant(tenant);

            return TenantAppMapper.toDTO(tenantRepository);
        }


    }
}
