package com.posun.domain.valueObject.Employee;

import com.posun.application.exception.valueObject.InformationNotNullException;

import java.util.Objects;

public final class NameVO {
    private final String value;

    public NameVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new InformationNotNullException("Name");
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
        NameVO nameVO = (NameVO) o;
        return Objects.equals(value, nameVO.value);
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
