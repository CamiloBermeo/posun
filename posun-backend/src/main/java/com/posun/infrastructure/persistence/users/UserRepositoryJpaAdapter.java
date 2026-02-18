package com.posun.infrastructure.persistence.users;

import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserModel;
import com.posun.domain.repository.IUserRepository;
import com.posun.infrastructure.entity.UserAdminEntity;
import com.posun.infrastructure.entity.UserEntity;
import com.posun.infrastructure.mapper.TenantInfraMapper;
import com.posun.infrastructure.mapper.UserAdminInfraMapper;
import com.posun.infrastructure.mapper.UserInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryJpaAdapter implements IUserRepository {
    private final IUserRepositoryJpa jpa;

    @Override
    @Transactional(readOnly = true)
    public UserModel findByEmail(String email) {

        UserEntity userEntity = jpa.findByEmail(email);
        return UserInfraMapper.toModel(userEntity, TenantInfraMapper.toDomain(userEntity.getTenant()));
    }

    @Override
    public UserAdmin save(UserAdmin userModel, Tenant tenant) {

        UserAdminEntity userAdmin = UserAdminInfraMapper.toEntity(userModel, TenantInfraMapper.toEntity(tenant));

        return UserAdminInfraMapper.toModel(jpa.save(userAdmin), tenant);
    }
}
