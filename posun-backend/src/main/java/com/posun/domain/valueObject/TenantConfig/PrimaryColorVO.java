package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class PrimaryColorVO {
    private final String primaryColor;

    public PrimaryColorVO(String primaryColor) {
        if (primaryColor == null || primaryColor.trim().isEmpty()) {
            throw new IllegalArgumentException("el color primario no puede estar vacio");
        }
        this.primaryColor = primaryColor;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PrimaryColorVO that = (PrimaryColorVO) o;
        return Objects.equals(primaryColor, that.primaryColor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(primaryColor);
    }

    @Override
    public String toString() {
        return primaryColor;
    }
}
