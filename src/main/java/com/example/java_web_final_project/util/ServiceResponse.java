package com.example.java_web_final_project.util;

import java.io.Serializable;

import lombok.Data;

@Data
public class ServiceResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String message;
	private Object object;

	public ServiceResponse() {
	}

	public ServiceResponse(Integer code, String message, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.object = object;
	}

}
