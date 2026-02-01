package com.posun.domain.model;

import com.posun.domain.valueObject.Employee.NameVO;
import com.posun.domain.valueObject.Employee.LastNameVO;
import com.posun.domain.valueObject.Employee.PhoneNumberVO;

import java.util.Set;

public class Employee {
    private Long EmployeeId;
    private Long tenantId;
    private NameVO name;
    private boolean status;
    private LastNameVO lastName;
    private PhoneNumberVO phoneNumber;
    private Set<ServiceType> serviceType;

    public Employee() {
    }

    public Employee(Long employeeId,Long tenantId, NameVO name, LastNameVO lastName, PhoneNumberVO phoneNumber,
            Set<ServiceType> serviceType, boolean status) {
        this.EmployeeId = employeeId;
        this.tenantId = tenantId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.status = status;
    }

    private Employee(EmployeeBuilder builder) {
        this.EmployeeId = builder.employeeId;
        this.tenantId = builder.tenantId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.serviceType = builder.serviceType;
        this.status = builder.status;
    }

    public EmployeeBuilder toBuilder() {
        return new EmployeeBuilder()
                .withEmployeeId(this.EmployeeId)
                .withTenantId(this.tenantId)
                .withName(this.name)
                .withLastName(this.lastName)
                .withPhoneNumber(this.phoneNumber)
                .withServiceType(this.serviceType)
                .withStatus(this.status);
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private Long employeeId;
        private Long tenantId;
        private NameVO name;
        private LastNameVO lastName;
        private PhoneNumberVO phoneNumber;
        private Set<ServiceType> serviceType;
        private boolean status;

        public EmployeeBuilder withEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public EmployeeBuilder withTenantId(Long tenantId) {
            this.tenantId = tenantId;
            return this;
        }
        public EmployeeBuilder withName(NameVO name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder withLastName(LastNameVO lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder withPhoneNumber(PhoneNumberVO phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public EmployeeBuilder withServiceType(Set<ServiceType> serviceType) {
            this.serviceType = serviceType;
            return this;
        }

        public EmployeeBuilder withStatus(boolean status) {
            this.status = status;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public NameVO getName() {
        return name;
    }

    public LastNameVO getLastName() {
        return lastName;
    }

    public PhoneNumberVO getPhoneNumber() {
        return phoneNumber;
    }

    public Set<ServiceType> getServiceType() {
        return serviceType;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public boolean isStatus() {
        return status;
    }
}
