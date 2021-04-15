package com.lgcns.project.rest_server_test.rest.excpetion;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	
	private ExceptionEnum error;
	
	public ApiException(ExceptionEnum e) {
		super(e.getMessage());
		this.error = e;
	}

}
