package com.posun.infrastructure.persistence.users;

import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserModel;
import com.posun.domain.repository.IUserRepository;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserEntity;
import com.posun.infrastructure.mapper.TenantInfraMapper;
import com.posun.infrastructure.mapper.UserInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryJpaAdapter implements IUserRepository {
    private final IUserRepositoryJpa jpa;

    @Override
    public UserModel findByEmail(String email) {

        UserEntity userEntity = jpa.findByEmail(email);
        Tenant tenant = TenantInfraMapper.toDomain(userEntity.getTenant());
        return UserInfraMapper.toModel(userEntity, tenant);
    }
}
