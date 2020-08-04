package com.example.rwbybackend.controllers;

import com.example.rwbybackend.controllers.forms.LoginForm;
import com.example.rwbybackend.dto.StringData;
import com.example.rwbybackend.dto.UserData;
import com.example.rwbybackend.repositories.user.UserRepository;
import com.example.rwbybackend.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {

	@NonNull
	private final UserService userService;

	@PostMapping("/login")
	public ResponseEntity<StringData> login(@RequestBody @Valid LoginForm form) {

		log.info("login {}", form.getUsername());

		StringData token = userService.login(form.getUsername(), form.getPassword());

		return ResponseEntity.ok(token);
	}
}
