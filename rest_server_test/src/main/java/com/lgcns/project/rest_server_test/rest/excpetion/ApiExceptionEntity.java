package com.lgcns.project.rest_server_test.rest.excpetion;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {
	private int errorCode;
	private String errorMessage;
	
	@Builder
	public ApiExceptionEntity(HttpStatus status, int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

		
}
