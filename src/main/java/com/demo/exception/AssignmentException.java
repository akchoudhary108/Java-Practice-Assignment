package com.demo.exception;

import lombok.Getter;

@Getter
public class AssignmentException extends RuntimeException{

	private final ErrorResponse errorResponse;

	public AssignmentException(ErrorResponse errorResponse, Throwable throwable) {
		super(throwable);
		this.errorResponse = errorResponse;
	}

	public AssignmentException(ErrorResponse errorResponse) {
		super();
		this.errorResponse = errorResponse;
	}
	
}
