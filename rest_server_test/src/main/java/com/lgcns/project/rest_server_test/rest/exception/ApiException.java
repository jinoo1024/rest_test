package com.lgcns.project.rest_server_test.rest.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	
	private ExceptionEnum error;
	
	public ApiException(ExceptionEnum e) {
		super(e.getMessage());
		this.error = e;
	}

}
