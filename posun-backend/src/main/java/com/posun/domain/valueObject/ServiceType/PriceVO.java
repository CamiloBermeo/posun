package com.posun.domain.valueObject.ServiceType;

import java.util.Objects;

public final class PriceVO {
    private final Double value;

    public PriceVO(Double value) {
        if (value == null) {
            throw new IllegalArgumentException("el precio no puede ser nulo");
        }
        if (value < 0) {
            throw new IllegalArgumentException("el precio no puede ser negativo");
        }
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PriceVO priceVO = (PriceVO) o;
        return Objects.equals(value, priceVO.value);
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
