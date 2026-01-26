package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class FaviconUrlVO {
    private final String faviconUrl;

    public FaviconUrlVO(String faviconUrl) {
        if (faviconUrl == null || faviconUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL del favicon no puede estar vacia");
        }
        this.faviconUrl = faviconUrl;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FaviconUrlVO that = (FaviconUrlVO) o;
        return Objects.equals(faviconUrl, that.faviconUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(faviconUrl);
    }

    @Override
    public String toString() {
        return faviconUrl;
    }
}
