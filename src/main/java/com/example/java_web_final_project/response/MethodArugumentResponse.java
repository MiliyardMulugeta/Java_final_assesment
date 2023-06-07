package com.example.java_web_final_project.response;

import lombok.Data;

@Data
public class MethodArugumentResponse {

	private Integer code;
	private String message;
	private Object data;

	public MethodArugumentResponse(Integer code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
