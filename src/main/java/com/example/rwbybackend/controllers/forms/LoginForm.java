package com.example.rwbybackend.controllers.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@Builder
public class LoginForm {

	@NotNull
	private final String username;

	@NotNull
	private final String password;

}
