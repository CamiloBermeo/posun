package com.posun.domain.valueObject.Tenant;

import com.posun.application.exception.valueObject.InformationNotNullException;

import java.util.Objects;

public final class BusinessNameVO {
    private final String value;

    public BusinessNameVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InformationNotNullException("businessName");
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
        BusinessNameVO that = (BusinessNameVO) o;
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
