package com.posun.domain.model;

import com.posun.domain.valueObject.TenantConfig.PrimaryColorVO;
import com.posun.domain.valueObject.TenantConfig.LogoUrlVO;
import com.posun.domain.valueObject.TenantConfig.FaviconUrlVO;
import com.posun.domain.valueObject.TenantConfig.WelcomeMessageVO;
import com.posun.domain.valueObject.TenantConfig.CancellationMaxHoursVO;

public class TenantConfig {
    private PrimaryColorVO primaryColor;
    private LogoUrlVO logoUrl;
    private FaviconUrlVO faviconUrl;
    private WelcomeMessageVO welcomeMessage;
    private boolean allowsCancellation;
    private CancellationMaxHoursVO cancellationMaxHours;

    public TenantConfig() {
    }

    public TenantConfig(PrimaryColorVO primaryColor, LogoUrlVO logoUrl, FaviconUrlVO faviconUrl,
            WelcomeMessageVO welcomeMessage, boolean allowsCancellation, CancellationMaxHoursVO cancellationMaxHours) {
        this.primaryColor = primaryColor;
        this.logoUrl = logoUrl;
        this.faviconUrl = faviconUrl;
        this.welcomeMessage = welcomeMessage;
        this.allowsCancellation = allowsCancellation;
        this.cancellationMaxHours = cancellationMaxHours;
    }

    private TenantConfig(TenantConfigBuilder builder) {
        this.primaryColor = builder.primaryColor;
        this.logoUrl = builder.logoUrl;
        this.faviconUrl = builder.faviconUrl;
        this.welcomeMessage = builder.welcomeMessage;
        this.allowsCancellation = builder.allowsCancellation;
        this.cancellationMaxHours = builder.cancellationMaxHours;
    }

    public TenantConfigBuilder toBuilder() {
        return new TenantConfigBuilder()
                .withPrimaryColor(this.primaryColor)
                .withLogoUrl(this.logoUrl)
                .withFaviconUrl(this.faviconUrl)
                .withWelcomeMessage(this.welcomeMessage)
                .withAllowsCancellation(this.allowsCancellation)
                .withCancellationMaxHours(this.cancellationMaxHours);
    }

    public static TenantConfigBuilder builder() {
        return new TenantConfigBuilder();
    }

    public static class TenantConfigBuilder {
        private PrimaryColorVO primaryColor;
        private LogoUrlVO logoUrl;
        private FaviconUrlVO faviconUrl;
        private WelcomeMessageVO welcomeMessage;
        private boolean allowsCancellation;
        private CancellationMaxHoursVO cancellationMaxHours;

        public TenantConfigBuilder withPrimaryColor(PrimaryColorVO primaryColor) {
            this.primaryColor = primaryColor;
            return this;
        }

        public TenantConfigBuilder withLogoUrl(LogoUrlVO logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public TenantConfigBuilder withFaviconUrl(FaviconUrlVO faviconUrl) {
            this.faviconUrl = faviconUrl;
            return this;
        }

        public TenantConfigBuilder withWelcomeMessage(WelcomeMessageVO welcomeMessage) {
            this.welcomeMessage = welcomeMessage;
            return this;
        }

        public TenantConfigBuilder withAllowsCancellation(boolean allowsCancellation) {
            this.allowsCancellation = allowsCancellation;
            return this;
        }

        public TenantConfigBuilder withCancellationMaxHours(CancellationMaxHoursVO cancellationMaxHours) {
            this.cancellationMaxHours = cancellationMaxHours;
            return this;
        }

        public TenantConfig build() {
            return new TenantConfig(this);
        }
    }

    public PrimaryColorVO getPrimaryColor() {
        return primaryColor;
    }

    public LogoUrlVO getLogoUrl() {
        return logoUrl;
    }

    public FaviconUrlVO getFaviconUrl() {
        return faviconUrl;
    }

    public WelcomeMessageVO getWelcomeMessage() {
        return welcomeMessage;
    }

    public boolean isAllowsCancellation() {
        return allowsCancellation;
    }

    public CancellationMaxHoursVO getCancellationMaxHours() {
        return cancellationMaxHours;
    }
}
