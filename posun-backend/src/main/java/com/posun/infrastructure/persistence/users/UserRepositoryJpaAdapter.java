package com.posun.infrastructure.persistence.users;

import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserModel;
import com.posun.domain.repository.IUserRepository;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;
import com.posun.infrastructure.entity.UserEntity;
import com.posun.infrastructure.mapper.TenantInfraMapper;
import com.posun.infrastructure.mapper.UserAdminInfraMapper;
import com.posun.infrastructure.mapper.UserInfraMapper;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryJpaAdapter implements IUserRepository {
    private final IUserRepositoryJpa jpa;
    private final EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public UserModel findByEmail(String email) {

        UserEntity userEntity = jpa.findByEmail(email);
        return UserInfraMapper.toModel(userEntity);
    }

    @Override
    public UserAdmin save(UserAdmin userModel, Long tenantId) {

        UserAdminEntity userAdmin = UserAdminInfraMapper.toEntity(userModel);

        TenantEntity tenantProxy = em.getReference(TenantEntity.class, tenantId);
        userAdmin.setTenant(tenantProxy);

        return UserAdminInfraMapper.toModel(jpa.save(userAdmin));
    }
}
