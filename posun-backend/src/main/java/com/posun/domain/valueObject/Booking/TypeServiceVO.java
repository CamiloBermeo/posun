package com.posun.domain.valueObject.Booking;

import java.util.Objects;

public final class TypeServiceVO {
    private final String typeService;

    public  TypeServiceVO(String typeService) {
        if(typeService==null && typeService.trim().isEmpty()) {
            throw new IllegalArgumentException("el tipo de servicio no puede estar vacio");
        }
        this.typeService = typeService;
    }

    public String getTypeService() {
        return typeService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeServiceVO that = (TypeServiceVO) o;
        return Objects.equals(typeService, that.typeService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(typeService);
    }
    @Override
    public String toString() {
        return typeService;
    }
}
