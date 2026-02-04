package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class FaviconUrlVO {
    private final String value;

    public FaviconUrlVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL del favicon no puede estar vacia");
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
        FaviconUrlVO that = (FaviconUrlVO) o;
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
