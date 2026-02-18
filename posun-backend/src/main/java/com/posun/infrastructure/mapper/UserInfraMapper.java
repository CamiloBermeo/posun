package com.posun.infrastructure.mapper;

import com.posun.domain.model.Tenant;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserClient;
import com.posun.domain.model.UserModel;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;
import com.posun.infrastructure.entity.UserClientEntity;
import com.posun.infrastructure.entity.UserEntity;

public class UserInfraMapper {

    public static UserModel toModel(UserEntity userEntity) {

        if (userEntity == null) {
            return null;
        }
        if (userEntity instanceof UserAdminEntity adminEntity) {
            return UserAdminInfraMapper.toModel(adminEntity);
        }
        if (userEntity instanceof UserClientEntity clientEntity){
            return UserClientInfraMapper.toModel(clientEntity);
        }
        throw new IllegalArgumentException("Tipo de usuario no soportado " + userEntity.getClass().getName());
    }

    public static UserEntity toEntity(UserModel userModel, TenantEntity entity) {
        if (userModel == null) {
            return null;
        }
        if (userModel instanceof UserAdmin userAdmin) {
            return UserAdminInfraMapper.toEntity(userAdmin, entity);
        }
        if (userModel instanceof UserClient client){
            return UserClientInfraMapper.toEntity(client, entity);
        }
        throw new IllegalArgumentException("Tipo de usuario no soportado " + userModel.getClass().getName());
    }
}
