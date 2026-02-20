package com.posun.domain.model;

import java.time.Instant;

public class RefreshToken {

    private Long id;
    private UserModel user;
    private String token;
    private Instant expiresAt;

    public RefreshToken() {}

    public RefreshToken(Long id, Instant expiresAt, String token, UserModel user) {
        this.id = id;
        this.expiresAt = expiresAt;
        this.token = token;
        this.user = user;
    }

    private RefreshToken(RefreshTokenBuilder builder) {
        this.id = builder.id;
        this.token = builder.token;
        this.user = builder.user;
        this.expiresAt = builder.expiresAt;
    }

    public RefreshTokenBuilder toBuilder() {
        return new RefreshTokenBuilder()
                .withId(id)
                .withToken(token)
                .withExpiresAt(expiresAt)
                .withUser(user);
    }
    public static RefreshTokenBuilder builder(){return new RefreshToken.RefreshTokenBuilder();}


    public static class RefreshTokenBuilder{
        private Long id;
        private UserModel user;
        private String token;
        private Instant expiresAt;

        public RefreshToken.RefreshTokenBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public RefreshToken.RefreshTokenBuilder withUser(UserModel user) {
            this.user = user;
            return this;
        }
        public RefreshToken.RefreshTokenBuilder withToken(String token) {
            this.token = token;
            return this;
        }
        public RefreshToken.RefreshTokenBuilder withExpiresAt(Instant expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }
        public RefreshToken build() {
            return new RefreshToken(this);
        }
    }

    public Long getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

}
