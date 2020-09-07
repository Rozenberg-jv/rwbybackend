package com.example.rwbybackend.controllers;

import com.example.rwbybackend.model.user.RoleName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
//@Secured("ROLE_ADMIN")
@RequiredArgsConstructor
public class ExampleController {

	@GetMapping("/ex1")
	@Secured(RoleName.ADMIN)
	public ResponseEntity<?> example1() {

		return ResponseEntity.ok(1);
	}
}


