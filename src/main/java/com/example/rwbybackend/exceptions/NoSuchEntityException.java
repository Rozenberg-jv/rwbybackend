package com.example.rwbybackend.exceptions;

public class NoSuchEntityException extends RuntimeException {

	public NoSuchEntityException(String message) {

		super(String.format("No such entity: %s ", message));
	}
}
