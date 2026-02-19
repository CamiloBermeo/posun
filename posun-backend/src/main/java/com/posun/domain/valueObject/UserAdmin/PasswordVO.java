package com.posun.domain.valueObject.UserAdmin;

import com.posun.application.exception.valueObject.InformationNotNullException;

import java.util.Objects;

public final class PasswordVO {
    private final String value;

    public PasswordVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InformationNotNullException("password");
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
        PasswordVO that = (PasswordVO) o;
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
