package com.posun.domain.valueObject.ServiceType;

import java.util.Objects;

public final class DescriptionServiceVO {
    private final String descriptionService;

    public DescriptionServiceVO(String descriptionService) {
        if (descriptionService == null || descriptionService.trim().isEmpty()) {
            throw new IllegalArgumentException("la descripcion del servicio no puede estar vacia");
        }
        this.descriptionService = descriptionService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DescriptionServiceVO that = (DescriptionServiceVO) o;
        return Objects.equals(descriptionService, that.descriptionService);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(descriptionService);
    }

    @Override
    public String toString() {
        return descriptionService;
    }
}
