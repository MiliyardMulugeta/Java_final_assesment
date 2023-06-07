package com.example.java_web_final_project.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.java_web_final_project.response.MethodArugumentResponse;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<MethodArugumentResponse> handleGlobalExceptions(MethodArgumentNotValidException ex,
			WebRequest request) {
		MethodArugumentResponse errorResponse = new MethodArugumentResponse(Integer.parseInt("400"),
				ex.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage())
						.collect(java.util.stream.Collectors.joining(",")),
				null);
		return new ResponseEntity<MethodArugumentResponse>(errorResponse, HttpStatus.OK);
	}

}
