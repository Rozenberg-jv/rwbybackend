package com.example.rwbybackend.configuration;

import com.example.rwbybackend.configuration.security.AuthenticationFilter;
import com.example.rwbybackend.configuration.security.TokenBasedAuthenticationProvider;
import com.example.rwbybackend.model.user.RoleName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpMethod.OPTIONS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public TokenBasedAuthenticationProvider tokenBasedAuthenticationProvider() {

		return new TokenBasedAuthenticationProvider();
	}

	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {

		return (request, response, authException) -> response
				.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
		filter.setPrincipalRequestHeader("USER");
		filter.setCredentialsRequestHeader("TOKEN");

		http.cors().and()
				.addFilterBefore(
						new AuthenticationFilter(authenticationManager()),
						BasicAuthenticationFilter.class)
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(OPTIONS, "/api/**")
				.permitAll()
				.antMatchers("/api/backoffice/**")
				.hasRole(RoleName.ADMIN.name())
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(unauthorizedEntryPoint());
		http.csrf().disable();

	}
}
