package com.example.SportyShoes.exception;

public class InvalidDateFormatException extends RuntimeException {

	private static String INVALID_DATE = "The give date format is invalid. Enter the date in the format dd/MM/yyyy ";

	public InvalidDateFormatException() {
		super();
	}

	@Override
	public String getMessage() {
		return INVALID_DATE;
	}

}
