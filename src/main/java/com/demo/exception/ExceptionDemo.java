package com.demo.exception;

import com.itextpdf.text.log.Logger;

public class ExceptionDemo {

	
	public static void main(String[] args) {		
		throw new AssignmentException(ErrorResponse.ASSIGNMENT_ERROR);
	}

}
