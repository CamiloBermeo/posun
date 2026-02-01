package com.posun.domain.model;

import com.posun.domain.valueObject.UserAdmin.PhoneNumberVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;

public class UserAdmin {
    private Long userAdminId;
    private Long tenantId;
    private PhoneNumberVO phoneNumber;
    private PasswordVO password;
    private TenantConfig tenantConfig;

    public UserAdmin() {
    }

    public UserAdmin(Long userAdminId, Long tenantId, PhoneNumberVO phoneNumber, PasswordVO password, TenantConfig tenantConfig) {
        this.userAdminId = userAdminId;
        this.tenantId = tenantId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.tenantConfig = tenantConfig;
    }

    private UserAdmin(UserAdminBuilder builder) {
        this.userAdminId = builder.userAdminId;
        this.tenantId = builder.tenantId;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
        this.tenantConfig = builder.tenantConfig;
    }

    public UserAdminBuilder toBuilder() {
        return new UserAdminBuilder()
                .withUserAdminId(this.userAdminId)
                .withTenantId(this.tenantId)
                .withPhoneNumber(this.phoneNumber)
                .withPassword(this.password)
                .withTenantConfig(this.tenantConfig);
    }

    public static UserAdminBuilder builder() {
        return new UserAdminBuilder();
    }

    public static class UserAdminBuilder {
        private Long userAdminId;
        private Long tenantId;
        private PhoneNumberVO phoneNumber;
        private PasswordVO password;
        private TenantConfig tenantConfig;

        public UserAdminBuilder withUserAdminId(Long userAdminId) {
            this.userAdminId = userAdminId;
            return this;
        }
        public UserAdminBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public UserAdminBuilder withPhoneNumber(PhoneNumberVO phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserAdminBuilder withPassword(PasswordVO password) {
            this.password = password;
            return this;
        }

        public UserAdminBuilder withTenantConfig(TenantConfig tenantConfig) {
            this.tenantConfig = tenantConfig;
            return this;
        }

        public UserAdmin build() {
            return new UserAdmin(this);
        }
    }

    public Long getUserAdminId() {
        return userAdminId;
    }

    public PhoneNumberVO getPhoneNumber() {
        return phoneNumber;
    }

    public PasswordVO getPassword() {
        return password;
    }

    public TenantConfig getTenantConfig() {
        return tenantConfig;
    }

    public Long getTenantId() {
        return tenantId;
    }
}
