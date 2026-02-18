package com.posun.application.mapper;

import com.posun.application.dto.userAdmin.UserAdminRequestDTO;
import com.posun.application.dto.userAdmin.UserAdminResponseDTO;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.model.UserPosition;
import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;

public class UserAdminAppMapper {

    public static UserAdmin toModel (UserAdminRequestDTO dto, String encodePassword) {
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

    public static UserAdminResponseDTO toDto (UserAdmin user) {
        return new UserAdminResponseDTO(
                user.getUserId(),
                user.getEmail().getValue(),
                user.getName().getValue(),
                user.getLastName().getValue(),
                user.getUserPosition().toString(),
                user.getStatus().getValue()

        );
    }
}
