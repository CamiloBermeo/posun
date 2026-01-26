package com.posun.domain.valueObject.Tenant;

import java.util.Objects;

public final class AssignedURLVO {
    private final String assignedURL;

    public AssignedURLVO(String assignedURL) {
        if (assignedURL == null || assignedURL.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL asignada no puede estar vacia");
        }
        this.assignedURL = assignedURL;
    }

    public String getAssignedURL() {
        return assignedURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AssignedURLVO that = (AssignedURLVO) o;
        return Objects.equals(assignedURL, that.assignedURL);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(assignedURL);
    }

    @Override
    public String toString() {
        return assignedURL;
    }
}
