package com.posun.domain.valueObject.Tenant;

import java.util.Objects;

public final class StatusVO {
    private final Boolean status;

    public StatusVO(Boolean status) {
        if (status == null) {
            throw new IllegalArgumentException("el estado no puede ser nulo");
        }
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StatusVO statusVO = (StatusVO) o;
        return Objects.equals(status, statusVO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status);
    }

    @Override
    public String toString() {
        return status.toString();
    }
}
