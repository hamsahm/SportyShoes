package com.example.SportyShoes.exception;

public class UserNotFoundException extends RuntimeException {

	private static String USER_NOT_FOUND = "User not found for the given User Id : ";
	private int id;

	public UserNotFoundException(int id) {
		super();
		this.id = id;
	}

	@Override
	public String getMessage() {
		return USER_NOT_FOUND + id;
	}

}
