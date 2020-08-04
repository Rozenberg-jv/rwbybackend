package com.example.rwbybackend.configuration.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenAuthority {

	private String softToken;
	private String hardToken;
}
