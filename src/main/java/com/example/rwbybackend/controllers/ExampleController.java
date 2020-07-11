package com.example.rwbybackend.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
@Secured("ROLE_ADMIN")
public class ExampleController {

	@GetMapping("/ex1")
	public ResponseEntity<?> example1() {

		return ResponseEntity.ok(1);
	}
}
