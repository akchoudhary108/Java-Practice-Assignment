package com.demo.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum ErrorResponse {

    ASSIGNMENT_ERROR("ERR_001", "Java Practice Assignment Error!!", ErrorType.ASSIGNMENT),
    PDF_ERROR("ERR_002","iText Pdf Error!!", ErrorType.ITEXT_PDF);
	
	
	private ErrorResponse(String code, String message, ErrorType errorLevel) {
		this.code = code;
		this.message = message;
		this.errorLevel = errorLevel;
	}
    
	private final String code;
    private final String message;
    private final ErrorType errorLevel;        
    
}