package com.example.subscribing.domain.exception;

import com.example.subscribing.domain.exception.Code.Code;
import org.springframework.http.HttpStatus;


public class CommonException extends RuntimeException{
	private Code code;
	private String message;
	private HttpStatus httpStatus;

	public CommonException(Code code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
