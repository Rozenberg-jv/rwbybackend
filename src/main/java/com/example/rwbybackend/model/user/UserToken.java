package com.example.rwbybackend.model.user;

import com.example.rwbybackend.services.util.TokenGenerator;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"token", "type", "expires"})
@Builder
public class UserToken {

    @Id
    @Column
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType type;

    @ManyToOne(optional = false)
    private User user;

    @Builder.Default
    private LocalDateTime expires = LocalDateTime.now().plusMinutes(30);

    @PrePersist
    private void generateToken() {

        if (token == null) {
            token = TokenGenerator.generateToken();
        }
    }

    public boolean isExpired() {

        return expires.isBefore(LocalDateTime.now());
    }

    public static UserToken generateHardUserToken(User user) {

        return UserToken.builder()
                .user(user)
                .type(TokenType.HARD)
                .token(TokenGenerator.generateToken())
                .expires(LocalDateTime.now().plusMinutes(TokenType.HARD.getExpiresMinute()))
                .build();
    }

    public static UserToken generateSoftUserToken(User user) {

        return UserToken.builder()
                .user(user)
                .type(TokenType.SOFT)
                .token(TokenGenerator.generateToken())
                .expires(LocalDateTime.now().plusMinutes(TokenType.SOFT.getExpiresMinute()))
                .build();
    }

    public static UserToken generatePasswordUserToken(User user) {

        return UserToken.builder()
                .user(user)
                .type(TokenType.PASSWORD_RESET)
                .token(TokenGenerator.generateToken())
                .expires(LocalDateTime.now().plusDays(TokenType.PASSWORD_RESET.getExpiresMinute()))
                .build();
    }
}