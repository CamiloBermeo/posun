package com.posun.domain.model;

import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;

public class UserClient extends  UserModel{


    public UserClient(Long userClientId, Long tenantId, NameVO name, LastNameVO lastName, PhoneNumberVO phoneNumber, PasswordVO password, EmailVO email) {
        super(userClientId, tenantId, phoneNumber, password, name, lastName, email);
    }

    private UserClient(UserClientBuilder builder) {
        super(builder.userClientId, builder.tenantId, builder.phoneNumber, builder.password, builder.name,builder.lastName, builder.email);
    }

    public UserClientBuilder toBuilder() {
        return new UserClientBuilder()
                .withTenantId(this.tenantId)
                .withName(this.name)
                .withLastName(this.lastName)
                .withPhoneNumber(this.phoneNumber)
                .withPassword(this.password);
    }

    public static UserClientBuilder builder() {
        return new UserClientBuilder();
    }

    public static class UserClientBuilder {
        private Long userClientId;
        private Long tenantId;
        private NameVO name;
        private LastNameVO lastName;
        private PhoneNumberVO phoneNumber;
        private EmailVO email;
        private PasswordVO password;

        public UserClientBuilder withUserClientId(Long userClientId) {
            this.userClientId = userClientId;
            return this;
        }


        public UserClientBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public UserClientBuilder withEmail(EmailVO email) {
            this.email = email;
            return this;
        }

        public UserClientBuilder withName(NameVO name) {
            this.name = name;
            return this;
        }

        public UserClientBuilder withLastName(LastNameVO lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserClientBuilder withPhoneNumber(PhoneNumberVO phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserClient build() {
            return new UserClient(this);
        }
        public UserClientBuilder withPassword(PasswordVO password) {
            this.password = password;
            return this;
        }
    }

}
