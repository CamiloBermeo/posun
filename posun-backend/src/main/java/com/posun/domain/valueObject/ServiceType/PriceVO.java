package com.posun.domain.valueObject.ServiceType;

import java.util.Objects;

public final class PriceVO {
    private final Double price;

    public PriceVO(Double price) {
        if (price == null) {
            throw new IllegalArgumentException("el precio no puede ser nulo");
        }
        if (price < 0) {
            throw new IllegalArgumentException("el precio no puede ser negativo");
        }
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PriceVO priceVO = (PriceVO) o;
        return Objects.equals(price, priceVO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }

    @Override
    public String toString() {
        return price.toString();
    }
}
