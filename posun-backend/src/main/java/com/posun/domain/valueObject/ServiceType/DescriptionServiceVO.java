package com.posun.domain.valueObject.ServiceType;

import java.util.Objects;

public final class DescriptionServiceVO {
    private final String value;

    public DescriptionServiceVO(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("la descripcion del servicio no puede estar vacia");
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
        DescriptionServiceVO that = (DescriptionServiceVO) o;
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
