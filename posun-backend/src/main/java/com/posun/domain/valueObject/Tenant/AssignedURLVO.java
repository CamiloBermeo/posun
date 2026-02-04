package com.posun.domain.valueObject.Tenant;

import java.text.Normalizer;
import java.util.Objects;

public final class AssignedURLVO {
    private final String value;

    public AssignedURLVO(String businessName) {
        if (businessName == null || businessName.trim().isEmpty()) {
            throw new IllegalArgumentException("la URL asignada no puede estar vacia");
        }
        this.value = assignedUrl(businessName);
    }

    //fabrica el slug que despues se unira con la url
    public static String assignedUrl(String businessName) {

        return  Normalizer.normalize( businessName.toLowerCase() , Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll(" ", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "")
                .replaceAll("ñ","n")
                .replaceAll("\\s+","-");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AssignedURLVO that = (AssignedURLVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
