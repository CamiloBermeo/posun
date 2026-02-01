package com.posun.domain.valueObject.Tenant;

import java.util.Objects;

public final class AssignedURLVO {
    private final String assignedURL;

    public AssignedURLVO(String businessName) {
        if (businessName == null || businessName.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL asignada no puede estar vacia");
        }
        this.assignedURL = assignedUrl(businessName);
    }

    //fabrica el slug que despues se unira con la url
    public static String assignedUrl(String businessName) {
        return businessName.toLowerCase()
                .replaceAll(" ", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
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
