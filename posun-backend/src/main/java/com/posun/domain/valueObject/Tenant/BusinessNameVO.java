package com.posun.domain.valueObject.Tenant;

import java.util.Objects;

public final class BusinessNameVO {
    private final String businessName;

    public BusinessNameVO(String businessName) {
        if (businessName == null || businessName.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre del negocio no puede estar vacio");
        }
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BusinessNameVO that = (BusinessNameVO) o;
        return Objects.equals(businessName, that.businessName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(businessName);
    }

    @Override
    public String toString() {
        return businessName;
    }
}
