package com.posun.domain.model;

import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;

public class UserAdmin extends UserModel{

    private final UserPosition userPosition;
    private final TenantConfig tenantConfig;
    private final StatusVO status;



    public UserAdmin(Long userAdminId, Long tenantId, PhoneNumberVO phoneNumber, PasswordVO password, TenantConfig tenantConfig,
                     NameVO name, LastNameVO lastName, UserPosition userPosition, EmailVO email, StatusVO status){
        super(userAdminId, tenantId, phoneNumber, password, name, lastName, email);
        this.tenantConfig = tenantConfig;
        this.userPosition = userPosition;
        this.status = status;
    }

    private UserAdmin(UserAdminBuilder builder) {

        super(builder.userAdminId, builder.tenantId, builder.phoneNumber, builder.password, builder.name, builder.lastName, builder.email);
        this.userPosition = builder.userPosition;
        this.tenantConfig = builder.tenantConfig;
        this.status = builder.status;
    }

    public UserAdminBuilder toBuilder() {
        return new UserAdminBuilder()
                .withTenantId(this.tenantId)
                .withName(this.name)
                .withUserPosition(this.userPosition)
                .withLastName(this.lastName)
                .withPhoneNumber(this.phoneNumber)
                .withEmail(this.email)
                .withPassword(this.password)
                .withTenantConfig(this.tenantConfig)
                .withStatus(this.status);
    }

    public static UserAdminBuilder builder() {
        return new UserAdminBuilder();
    }

    public static class UserAdminBuilder {
        private Long userAdminId;
        private Long tenantId;
        private NameVO name;
        private LastNameVO lastName;
        private UserPosition userPosition;
        private PhoneNumberVO phoneNumber;
        private EmailVO email;
        private PasswordVO password;
        private TenantConfig tenantConfig;
        private StatusVO status;

        public UserAdminBuilder withUserAdminId(Long userAdminId) {
            this.userAdminId = userAdminId;
            return this;
        }
        public UserAdminBuilder withStatus(StatusVO status) {
            this.status = status;
            return this;
        }
        public UserAdminBuilder withEmail(EmailVO email) {
            this.email = email;
            return this;
        }
        public UserAdminBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public UserAdminBuilder withName(NameVO name) {
            this.name = name;
            return this;
        }
        public UserAdminBuilder withLastName(LastNameVO lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserAdminBuilder withUserPosition(UserPosition userPosition) {
            this.userPosition = userPosition;
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

    public StatusVO getStatus() {
        return status;
    }
    public UserPosition getUserPosition() {
        return userPosition;
    }
    public TenantConfig getTenantConfig() {
        return tenantConfig;
    }
}
