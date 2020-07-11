package com.example.rwbybackend.model.user;

import lombok.Getter;

public enum TokenType {

	HARD(60),
	SOFT(30),
	PASSWORD_RESET(120);

	TokenType(int expiresMinute) {

		this.expiresMinute = expiresMinute;
	}

	@Getter
	private final int expiresMinute;

}
