package com.posun.domain.model;

import com.posun.domain.valueObject.Tenant.BusinessNameVO;
import com.posun.domain.valueObject.Tenant.AssignedURLVO;
import com.posun.domain.valueObject.Tenant.StatusVO;

import java.time.LocalDateTime;

public class Tenant {
    private Long tenantId;
    private BusinessNameVO businessName;
    private AssignedURLVO AssignedURL;
    private StatusVO status;
    private LocalDateTime createdAt;
    private TenantConfig tenantConfig;

    public Tenant() {
    }

    public Tenant(Long tenantId, BusinessNameVO businessName, AssignedURLVO assignedURL, StatusVO status, LocalDateTime createdAt, TenantConfig tenantConfig) {
        this.tenantId = tenantId;
        this.businessName = businessName;
        this.AssignedURL = assignedURL;
        this.status = status;
        this.createdAt = LocalDateTime.now();//asigna la hora actual
        this.tenantConfig = tenantConfig;

    }

    private Tenant(TenantBuilder builder) {
        this.tenantId = builder.tenantId;
        this.businessName = builder.businessName;
        this.AssignedURL = builder.assignedURL;
        this.status = builder.status;
        this.createdAt = builder.createdAt;
        this.tenantConfig = builder.tenantConfig;

    }

    public TenantBuilder toBuilder() {
        return new TenantBuilder()
                .withTenantId(this.tenantId)
                .withBusinessName(this.businessName)
                .withAssignedURL(this.AssignedURL)
                .withStatus(this.status)
                .withCreatedAt(LocalDateTime.now())
                .withTenantConfig(this.tenantConfig);
    }

    public static TenantBuilder builder() {
        return new TenantBuilder();
    }

    public static class TenantBuilder {
        private Long tenantId;
        private BusinessNameVO businessName;
        private AssignedURLVO assignedURL;
        private LocalDateTime createdAt;
        private StatusVO status;
        private TenantConfig tenantConfig;

        public TenantBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public TenantBuilder withBusinessName(BusinessNameVO businessName) {
            this.businessName = businessName;
            return this;
        }

        public TenantBuilder withAssignedURL(AssignedURLVO assignedURL) {
            this.assignedURL = assignedURL;
            return this;
        }

        public TenantBuilder withStatus(StatusVO status) {
            this.status = status;
            return this;
        }
        public TenantBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Tenant build() {
            return new Tenant(this);
        }
        public TenantBuilder withTenantConfig(TenantConfig tenantConfig) {
            this.tenantConfig = tenantConfig;
            return this;
        }
    }

    public Long getTenantId() {
        return tenantId;
    }

    public BusinessNameVO getBusinessName() {
        return businessName;
    }

    public AssignedURLVO getAssignedURL() {
        return AssignedURL;
    }

    public StatusVO getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public TenantConfig getTenantConfig() {
        return tenantConfig;
    }
}
