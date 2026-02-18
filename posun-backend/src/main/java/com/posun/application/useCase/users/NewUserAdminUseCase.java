package com.posun.application.useCase.users;

import com.posun.application.dto.userAdmin.UserAdminRequestDTO;
import com.posun.application.dto.userAdmin.UserAdminResponseDTO;
import com.posun.application.mapper.UserAdminAppMapper;
import com.posun.application.useCase.tenant.FindTenantByIdUseCase;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserAdminUseCase {

    private final PasswordEncoder  passwordEncoder;
    private final IUserRepository repository;
    private final FindTenantByIdUseCase findTenantByIdUseCase;

    public UserAdminResponseDTO execute (UserAdminRequestDTO dto, Long tenantId){

        String encodePassword = passwordEncoder.encode(dto.password());
        Tenant tenant = findTenantByIdUseCase.execute(tenantId);
        UserAdmin admin = UserAdminAppMapper.toModel(dto, encodePassword);
        return UserAdminAppMapper.toDto( repository.save(admin, tenant.getTenantId()));

    }

}
