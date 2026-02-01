package com.posun.domain.valueObject.UserClient;

import java.util.Objects;

public final class NameVO {
    private final String name;

    public NameVO(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede estar vacio");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NameVO nameVO = (NameVO) o;
        return Objects.equals(name, nameVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
