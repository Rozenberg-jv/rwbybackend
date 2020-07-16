package com.example.rwbybackend.exceptions;

public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(String username) {

		super(String.format("Invalid password for user %s", username));
	}
}
