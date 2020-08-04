package com.example.rwbybackend.model.user;

import lombok.Getter;

public enum TokenType {


    HARD(6000),
    SOFT(3000),
    PASSWORD_RESET(12000);

    TokenType(int expiresMinute) {

        this.expiresMinute = expiresMinute;
    }

    @Getter
    private final int expiresMinute;

}

