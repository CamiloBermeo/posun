package com.posun.domain.valueObject.UserAdmin;

import java.util.Objects;

public final class PhoneNumberVO {
    private final String phoneNumber;

    public PhoneNumberVO(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("el numero de telefono no puede estar vacio");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PhoneNumberVO that = (PhoneNumberVO) o;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phoneNumber);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
