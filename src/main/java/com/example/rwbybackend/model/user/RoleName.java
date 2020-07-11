package com.example.rwbybackend.model.user;

import lombok.Getter;

public enum RoleName {

	GUEST("ROLE_GUEST"),
	ADMIN("ROLE_ADMIN");

	RoleName(String roleName) {

		this.roleName = roleName;
	}

	@Getter
	private final String roleName;
}
