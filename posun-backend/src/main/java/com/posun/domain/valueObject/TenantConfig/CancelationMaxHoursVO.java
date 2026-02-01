package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class CancelationMaxHoursVO {
    private final Integer cancelationMaxHours;

    public CancelationMaxHoursVO(Integer cancelationMaxHours) {
        if (cancelationMaxHours == null) {
            throw new IllegalArgumentException("las horas maximas de cancelacion no pueden ser nulas");
        }
        if (cancelationMaxHours < 0) {
            throw new IllegalArgumentException("las horas maximas de cancelacion no pueden ser negativas");
        }
        this.cancelationMaxHours = cancelationMaxHours;
    }

    public Integer getCancelationMaxHours() {
        return cancelationMaxHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CancelationMaxHoursVO that = (CancelationMaxHoursVO) o;
        return Objects.equals(cancelationMaxHours, that.cancelationMaxHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cancelationMaxHours);
    }

    @Override
    public String toString() {
        return cancelationMaxHours.toString();
    }
}
