package com.posun.domain.model;

import com.posun.domain.valueObject.TenantConfig.PrimaryColorVO;
import com.posun.domain.valueObject.TenantConfig.LogoUrlVO;
import com.posun.domain.valueObject.TenantConfig.FaviconUrlVO;
import com.posun.domain.valueObject.TenantConfig.WelcomeMessageVO;
import com.posun.domain.valueObject.TenantConfig.CancelationMaxHoursVO;

public class TenantConfig {
    private PrimaryColorVO primaryColor;
    private LogoUrlVO logoUrl;
    private FaviconUrlVO faviconUrl;
    private WelcomeMessageVO welcomeMessage;
    private boolean allowsCancelation;
    private CancelationMaxHoursVO cancelationMaxHours;

    public TenantConfig() {
    }

    public TenantConfig(PrimaryColorVO primaryColor, LogoUrlVO logoUrl, FaviconUrlVO faviconUrl,
            WelcomeMessageVO welcomeMessage, boolean allowsCancelation, CancelationMaxHoursVO cancelationMaxHours) {
        this.primaryColor = primaryColor;
        this.logoUrl = logoUrl;
        this.faviconUrl = faviconUrl;
        this.welcomeMessage = welcomeMessage;
        this.allowsCancelation = allowsCancelation;
        this.cancelationMaxHours = cancelationMaxHours;
    }

    private TenantConfig(TenantConfigBuilder builder) {
        this.primaryColor = builder.primaryColor;
        this.logoUrl = builder.logoUrl;
        this.faviconUrl = builder.faviconUrl;
        this.welcomeMessage = builder.welcomeMessage;
        this.allowsCancelation = builder.allowsCancelation;
        this.cancelationMaxHours = builder.cancelationMaxHours;
    }

    public TenantConfigBuilder toBuilder() {
        return new TenantConfigBuilder()
                .withPrimaryColor(this.primaryColor)
                .withLogoUrl(this.logoUrl)
                .withFaviconUrl(this.faviconUrl)
                .withWelcomeMessage(this.welcomeMessage)
                .withAllowsCancelation(this.allowsCancelation)
                .withCancelationMaxHours(this.cancelationMaxHours);
    }

    public static TenantConfigBuilder builder() {
        return new TenantConfigBuilder();
    }

    public static class TenantConfigBuilder {
        private PrimaryColorVO primaryColor;
        private LogoUrlVO logoUrl;
        private FaviconUrlVO faviconUrl;
        private WelcomeMessageVO welcomeMessage;
        private boolean allowsCancelation;
        private CancelationMaxHoursVO cancelationMaxHours;

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

        public TenantConfigBuilder withAllowsCancelation(boolean allowsCancelation) {
            this.allowsCancelation = allowsCancelation;
            return this;
        }

        public TenantConfigBuilder withCancelationMaxHours(CancelationMaxHoursVO cancelationMaxHours) {
            this.cancelationMaxHours = cancelationMaxHours;
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

    public boolean isAllowsCancelation() {
        return allowsCancelation;
    }

    public CancelationMaxHoursVO getCancelationMaxHours() {
        return cancelationMaxHours;
    }
}
