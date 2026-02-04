package com.posun.domain.valueObject.UserAdmin;

import java.util.Objects;

public final class PhoneNumberVO {
    private final String value;

    public PhoneNumberVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("el numero de telefono no puede estar vacio");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PhoneNumberVO that = (PhoneNumberVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
