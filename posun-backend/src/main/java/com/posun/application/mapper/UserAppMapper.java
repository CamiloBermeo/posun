package com.posun.application.mapper;

import com.posun.application.dto.userAdmin.UserRequestDTO;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserModel;

import java.util.List;

public class UserAppMapper {
    public static UserAdmin toModel(UserRequestDTO dto, String encodePassword){
        if (dto.userPosition().isEmpty()){
            return UserAdminAppMapper.toModel(dto, encodePassword);
        }
        throw new IllegalArgumentException("...");
    }

}
