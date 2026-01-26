package com.posun.domain.valueObject.UserClient;

import java.util.Objects;

public final class LastNameVO {
    private final String lastName;

    public LastNameVO(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("el apellido no puede estar vacio");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LastNameVO that = (LastNameVO) o;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lastName);
    }

    @Override
    public String toString() {
        return lastName;
    }
}
