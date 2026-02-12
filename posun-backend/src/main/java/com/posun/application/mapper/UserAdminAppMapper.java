package com.posun.application.mapper;

import com.posun.application.dto.userAdmin.UserRequestDTO;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserPosition;
import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;

import java.util.List;

public class UserAdminAppMapper {

    public static UserAdmin toModel (UserRequestDTO dto, String encodePassword) {
        return UserAdmin.builder()
                .withName(new NameVO(dto.name()))
                .withLastName(new LastNameVO(dto.lastName()))
                .withUserPosition(UserPosition.valueOf(dto.userPosition()))
                .withPhoneNumber(new PhoneNumberVO(dto.phoneNumber()))
                .withEmail(new EmailVO(dto.email()))
                .withPassword(new PasswordVO(encodePassword))
                .withStatus(new StatusVO(true))
                .build();
    }

}
