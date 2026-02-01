package com.posun.domain.valueObject.UserAdmin;

import java.util.Objects;

public final class PasswordVO {
    private final String password;

    public PasswordVO(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("la contraseña no puede estar vacia");
        }
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PasswordVO that = (PasswordVO) o;
        return Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password);
    }

    @Override
    public String toString() {
        return password;
    }
}
