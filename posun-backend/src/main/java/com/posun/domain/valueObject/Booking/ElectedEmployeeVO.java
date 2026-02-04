package com.posun.domain.valueObject.Booking;

import java.util.Objects;

public final class ElectedEmployeeVO {
    private final String value;

    public ElectedEmployeeVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("el empleado elegido no puede estar vacio");
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
        ElectedEmployeeVO that = (ElectedEmployeeVO) o;
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
