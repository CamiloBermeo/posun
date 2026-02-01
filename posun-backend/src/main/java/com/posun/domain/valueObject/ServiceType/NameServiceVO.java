package com.posun.domain.valueObject.ServiceType;

import java.util.Objects;

public final class NameServiceVO {
    private final String nameService;

    public NameServiceVO(String nameService) {
        if (nameService == null || nameService.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre del servicio no puede estar vacio");
        }
        this.nameService = nameService;
    }

    public String getNameService() {
        return nameService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NameServiceVO that = (NameServiceVO) o;
        return Objects.equals(nameService, that.nameService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameService);
    }

    @Override
    public String toString() {
        return nameService;
    }
}
