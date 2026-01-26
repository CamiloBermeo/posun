package com.posun.domain.valueObject.TenantConfig;

import java.util.Objects;

public final class WelcomeMessageVO {
    private final String welcomeMessage;

    public WelcomeMessageVO(String welcomeMessage) {
        if (welcomeMessage == null || welcomeMessage.trim().isEmpty()) {
            throw new IllegalArgumentException("el mensaje de bienvenida no puede estar vacio");
        }
        this.welcomeMessage = welcomeMessage;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WelcomeMessageVO that = (WelcomeMessageVO) o;
        return Objects.equals(welcomeMessage, that.welcomeMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(welcomeMessage);
    }

    @Override
    public String toString() {
        return welcomeMessage;
    }
}
