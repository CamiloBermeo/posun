package com.posun.infrastructure.mapper;

import com.posun.domain.model.UserAdmin;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdminInfraMapper {

    public static UserAdminEntity toEntity(UserAdmin model, TenantEntity tenantEntity) {

        return UserAdminEntity.builder()
                .tenant(tenantEntity)
                .name(model.getName().getValue())
                .lastName(model.getLastName().getValue())
                .phoneNumber(model.getPhoneNumber().getValue())
                .email(model.getEmail().getValue())
                .passwordHash(model.getPassword().getValue())
                .active(model.getStatus().getValue())
                .userPosition(model.getUserPosition())
                .build();

    }

    public static UserAdmin toModel(UserAdminEntity Entity) {
        return null;
    }
    public static List<UserAdminEntity> toEntityList(List<UserAdmin> models, TenantEntity tenantEntity) {
        if (models == null || models.isEmpty()) {
            return Collections.emptyList();
        }

        return models.stream()
                .map(model -> toEntity(model, tenantEntity)) // Reutilizamos el mapeo individual
                .collect(Collectors.toList());
    }
}
