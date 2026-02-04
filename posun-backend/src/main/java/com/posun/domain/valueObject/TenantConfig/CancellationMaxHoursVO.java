package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class CancellationMaxHoursVO {
    private final Integer value;

    public CancellationMaxHoursVO(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("las horas maximas de cancelacion no pueden ser nulas");
        }
        if (value < 0) {
            throw new IllegalArgumentException("las horas maximas de cancelacion no pueden ser negativas");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CancellationMaxHoursVO that = (CancellationMaxHoursVO) o;
        return Objects.equals(value, that.value);
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
