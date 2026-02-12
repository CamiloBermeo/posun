package com.posun.domain.model;

import com.posun.domain.valueObject.Employee.EmailVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;
import com.posun.domain.valueObject.UserAdmin.PasswordVO;


public abstract class UserModel {

    protected final Long userId;
    protected final Tenant tenant;
    protected final NameVO name;
    protected final LastNameVO lastName;
    protected final PhoneNumberVO phoneNumber;
    protected final EmailVO email;
    protected final PasswordVO password;


    protected UserModel(Long userId, Tenant tenant, PhoneNumberVO phoneNumber, PasswordVO password,
                        NameVO name, LastNameVO lastName,EmailVO email) {
        this.userId = userId;
        this.tenant = tenant;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;

    }

    public EmailVO getEmail() {
        return email;
    }

    public Long getUserId() {
        return userId;
    }

    public Tenant getTenant() {
        return tenant;
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

    public PasswordVO getPassword() {
        return password;
    }

}


