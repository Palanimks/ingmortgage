package com.ing.mortgageloan.exception;

public class ResponseError {

	private String message;
	private int statusCode;

	public ResponseError(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
