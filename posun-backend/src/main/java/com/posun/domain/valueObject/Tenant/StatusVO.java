package com.posun.domain.valueObject.Tenant;

import com.posun.application.exception.valueObject.InformationNotNullException;

import java.util.Objects;

public final class StatusVO {
    private final Boolean value;

    public StatusVO(Boolean value) {
        if (value == null) {
            throw new InformationNotNullException("Status");
        }
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StatusVO statusVO = (StatusVO) o;
        return Objects.equals(value, statusVO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
