package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class LogoUrlVO {
    private final String logoUrl;

    public LogoUrlVO(String logoUrl) {
        if (logoUrl == null || logoUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL del logo no puede estar vacia");
        }
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LogoUrlVO logoUrlVO = (LogoUrlVO) o;
        return Objects.equals(logoUrl, logoUrlVO.logoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(logoUrl);
    }

    @Override
    public String toString() {
        return logoUrl;
    }
}
