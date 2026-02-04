package com.posun.domain.valueObject.Employee;

import java.util.Objects;

public final class EmailVO {
    private final String value;

    public EmailVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("el value no puede estar vacio");
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
        EmailVO that = (EmailVO) o;
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
