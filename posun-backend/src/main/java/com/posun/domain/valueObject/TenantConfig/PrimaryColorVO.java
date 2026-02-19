package com.posun.domain.valueObject.TenantConfig;

import com.posun.application.exception.valueObject.InformationNotNullException;

import java.util.Objects;

public final class PrimaryColorVO {
    private final String value;

    public PrimaryColorVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InformationNotNullException("PrimaryColor");
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
        PrimaryColorVO that = (PrimaryColorVO) o;
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
