package com.posun.infrastructure.mapper;

import com.posun.domain.model.UserModel;
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

}
