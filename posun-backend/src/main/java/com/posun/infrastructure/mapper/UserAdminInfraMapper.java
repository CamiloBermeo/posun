package com.posun.infrastructure.mapper;

import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserAdminInfraMapper {

    public static UserAdminEntity toEntity(UserAdmin model) {

        return UserAdminEntity.builder()
                .name(model.getName().getValue())
                .lastName(model.getLastName().getValue())
                .phoneNumber(model.getPhoneNumber().getValue())
                .email(model.getEmail().getValue())
                .passwordHash(model.getPassword().getValue())
                .active(model.getStatus().getValue())
                .userPosition(model.getUserPosition())
                .build();

    }

    public static UserAdmin toModel(UserAdminEntity entity) {
        UserAdmin.UserAdminBuilder builder = UserAdmin.builder()
                .withUserAdminId(entity.getId())
                .withName(new NameVO(entity.getName()))
                .withLastName(new LastNameVO(entity.getLastName()))
                .withUserPosition(entity.getUserPosition())
                .withStatus(new StatusVO(entity.isActive()))
                .withEmail(new EmailVO(entity.getEmail()))
                .withPassword(new PasswordVO(entity.getPasswordHash()));
        return builder.build();
    }
    public static List<UserAdminEntity> toEntityList(List<UserAdmin> models, TenantEntity tenantEntity) {
        if (models == null || models.isEmpty()) {
            return Collections.emptyList();
        }

        return models.stream()
                .map(model -> toEntity(model)) // Reutilizamos el mapeo individual
                .collect(Collectors.toList());
    }
}
