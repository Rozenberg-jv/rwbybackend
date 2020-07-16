package com.example.rwbybackend.controllers.forms;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class LoginForm {

	@NotNull
	private final String username;

	@NotNull
	private final String password;

}
