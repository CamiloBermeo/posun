package com.posun.domain.model;

import com.posun.domain.valueObject.UserAdmin.PasswordVO;
import com.posun.domain.valueObject.UserClient.NameVO;
import com.posun.domain.valueObject.UserClient.LastNameVO;
import com.posun.domain.valueObject.UserClient.PhoneNumberVO;

public class UserClient {
    private Long userClientId;
    private Long tenantId;
    private NameVO name;
    private LastNameVO lastName;
    private PhoneNumberVO phoneNumber;
    private PasswordVO password;

    public UserClient() {
    }

    public UserClient(Long userClientId, Long tenantId,  NameVO name, LastNameVO lastName, PhoneNumberVO phoneNumber,PasswordVO password) {
        this.userClientId = userClientId;
        this.tenantId = tenantId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    private UserClient(UserClientBuilder builder) {
        this.userClientId = builder.userClientId;
        this.tenantId = builder.tenantId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
    }

    public UserClientBuilder toBuilder() {
        return new UserClientBuilder()
                .withUserClientId(this.userClientId)
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
        private PasswordVO password;

        public UserClientBuilder withUserClientId(Long userClientId) {
            this.userClientId = userClientId;
            return this;
        }


        public UserClientBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
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

    public Long getUserClientId() {
        return userClientId;
    }

    public NameVO getName() {
        return name;
    }

    public LastNameVO getLastName() {
        return lastName;
    }

    public PhoneNumberVO getPhoneNumber() {
        return phoneNumber;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public PasswordVO getPassword() {
        return password;
    }
}
