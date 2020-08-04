package com.example.rwbybackend.configuration.security;

import com.example.rwbybackend.model.user.TokenType;
import com.example.rwbybackend.model.user.UserToken;
import com.example.rwbybackend.services.user.UserTokenService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;

public class TokenBasedAuthenticationProvider implements AuthenticationProvider {

	@Resource
	private UserTokenService userTokenService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		PreAuthenticatedAuthenticationToken authenticationToken = (PreAuthenticatedAuthenticationToken) authentication;
		if (authenticationToken == null) {
			return null;
		}
		if (!(authenticationToken.getCredentials() instanceof TokenAuthority)) {
			return null;
		}
		UserToken validToken = null;

		TokenAuthority tokenAuthority = (TokenAuthority) authenticationToken.getCredentials();
		if (tokenAuthority.getHardToken() != null) {
			validToken = userTokenService.findValidUserTokenByUsernameTypeAndToken(
					(String) authenticationToken.getPrincipal(),
					tokenAuthority.getHardToken(), TokenType.HARD);
		}
		System.out.println(LocalDateTime.now());
		if (validToken == null && tokenAuthority.getSoftToken() != null) {
			validToken = userTokenService.findValidUserTokenByUsernameTypeAndToken(
					(String) authenticationToken.getPrincipal(),
					tokenAuthority.getSoftToken(), TokenType.SOFT);
		}

		if (validToken != null) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + validToken.getUser().getRole().getRole());

			return new PreAuthenticatedAuthenticationToken(validToken.getUser(), validToken, Collections.singleton(authority));
		}

		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(PreAuthenticatedAuthenticationToken.class);
	}
}
