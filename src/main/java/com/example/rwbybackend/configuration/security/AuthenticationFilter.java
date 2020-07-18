package com.example.rwbybackend.configuration.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationFilter extends GenericFilterBean {

    private static final String HARD_TOKEN_HEADER = "X-Auth-HARDTOKEN";
    private static final String SOFT_TOKEN_HEADER = "X-Auth-SOFTTOKEN";
    private static final String USER_SESSION_KEY = "X-Auth-USER";

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {

        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String username = httpRequest.getHeader(USER_SESSION_KEY);
        String hardToken = httpRequest.getHeader(HARD_TOKEN_HEADER);
        String softToken = httpRequest.getHeader(SOFT_TOKEN_HEADER);

        if (username != null) {
            TokenAuthority tokenAuthority = TokenAuthority.builder()
                    .hardToken(hardToken)
                    .softToken(softToken)
                    .build();
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(username, tokenAuthority);
            Authentication auth = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }
}
