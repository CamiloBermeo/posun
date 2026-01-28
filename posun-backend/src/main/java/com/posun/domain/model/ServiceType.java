package com.posun.domain.model;

import com.posun.domain.valueObject.ServiceType.NameServiceVO;
import com.posun.domain.valueObject.ServiceType.DescriptionServiceVO;
import com.posun.domain.valueObject.ServiceType.PriceVO;

public class ServiceType {
    private Long serviceTypeId;
    private Long tenantId;
    private NameServiceVO nameService;
    private DescriptionServiceVO descriptionService;
    private PriceVO price;
    private Integer durationMinutes;
    private boolean active;

    public ServiceType() {
    }

    public ServiceType(Long serviceTypeId, Long tenantId, NameServiceVO nameService, DescriptionServiceVO descriptionService,
                       PriceVO price, Integer durationMinutes, boolean active) {
        this.serviceTypeId = serviceTypeId;
        this.tenantId = tenantId;
        this.nameService = nameService;
        this.descriptionService = descriptionService;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.active = active;
    }

    private ServiceType(ServiceTypeBuilder builder) {
        this.serviceTypeId = builder.serviceTypeId;
        this.tenantId = builder.tenantId;
        this.nameService = builder.nameService;
        this.descriptionService = builder.descriptionService;
        this.price = builder.price;
        this.durationMinutes = builder.durationMinutes;
        this.active = builder.active;

    }

    public ServiceTypeBuilder toBuilder() {
        return new ServiceTypeBuilder()
                .withServiceTypeId(this.serviceTypeId)
                .withTenantId(this.tenantId)
                .withNameService(this.nameService)
                .withDescriptionService(this.descriptionService)
                .withPrice(this.price)
                .withDurationMinutes(this.durationMinutes)
                .withActive(this.active);

    }

    public static ServiceTypeBuilder builder() {
        return new ServiceTypeBuilder();
    }

    public static class ServiceTypeBuilder {
        private Long serviceTypeId;
        private Long tenantId;
        private NameServiceVO nameService;
        private DescriptionServiceVO descriptionService;
        private PriceVO price;
        private Integer durationMinutes;
        private boolean active;


        public ServiceTypeBuilder withServiceTypeId(Long serviceTypeId) {
            this.serviceTypeId = serviceTypeId;
            return this;
        }

        public ServiceTypeBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public ServiceTypeBuilder withNameService(NameServiceVO nameService) {
            this.nameService = nameService;
            return this;
        }

        public ServiceTypeBuilder withDescriptionService(DescriptionServiceVO descriptionService) {
            this.descriptionService = descriptionService;
            return this;
        }

        public ServiceTypeBuilder withPrice(PriceVO price) {
            this.price = price;
            return this;
        }

        public ServiceTypeBuilder withDurationMinutes(Integer durationMinutes) {
            this.durationMinutes= durationMinutes;
            return this;
        }
        public ServiceTypeBuilder withActive(boolean active) {
            this.active = active;
            return this;
        }

        public ServiceType build() {
            return new ServiceType(this);
        }
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public NameServiceVO getNameService() {
        return nameService;
    }

    public DescriptionServiceVO getDescriptionService() {
        return descriptionService;
    }

    public PriceVO getPrice() {
        return price;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isActive() {
        return active;
    }
}