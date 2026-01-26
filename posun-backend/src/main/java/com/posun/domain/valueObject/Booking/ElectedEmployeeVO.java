package com.posun.domain.valueObject.Booking;

import java.util.Objects;

public final class ElectedEmployeeVO {
    private final String electedEmployee;

    public ElectedEmployeeVO(String electedEmployee) {
        if (electedEmployee == null || electedEmployee.trim().isEmpty()) {
            throw new IllegalArgumentException("el empleado elegido no puede estar vacio");
        }
        this.electedEmployee = electedEmployee;
    }

    public String getElectedEmployee() {
        return electedEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ElectedEmployeeVO that = (ElectedEmployeeVO) o;
        return Objects.equals(electedEmployee, that.electedEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(electedEmployee);
    }

    @Override
    public String toString() {
        return electedEmployee;
    }
}
