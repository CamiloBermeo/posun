package com.posun.infrastructure.mapper;

import com.posun.domain.model.UserClient;
import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;
import com.posun.infrastructure.entity.UserClientEntity;

public class UserClientInfraMapper {

    public static UserClient toModel (UserClientEntity entity){

        UserClient.UserClientBuilder userClientBuilder = UserClient.builder()
                .withUserClientId(entity.getId())
                .withName(new NameVO(entity.getName()))
                .withLastName(new LastNameVO(entity.getLastName()))
                .withPhoneNumber(new PhoneNumberVO(entity.getPhoneNumber()))
                .withEmail(new EmailVO(entity.getEmail()))
                .withPassword(new PasswordVO(entity.getPasswordHash()))
                .withTenantId(entity.getTenant().getId())
                .build().toBuilder();

        return userClientBuilder.build();
    }

}
