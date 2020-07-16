package com.example.rwbybackend.services.util;

import java.util.concurrent.ThreadLocalRandom;

public class TokenGenerator {

	private static final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String generateToken() {

		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < 45; i++) {
			buffer.append(alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length())));
		}
		return buffer.toString();
	}
}
