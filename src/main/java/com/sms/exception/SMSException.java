package com.sms.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;
	private Object object;

	public SMSException(String message, Throwable cause) {
		super(message, cause);
	}

	public SMSException(String message) {
		super(message);
	}

	public SMSException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public SMSException(String message, HttpStatus statusCode, Object object) {
		super(message);
		this.statusCode = statusCode;
		this.object = object;
	}
}
