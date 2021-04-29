package com.lgcns.project.rest_server_test.rest.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {
	
	@JsonProperty("code")
	private int httpErrorCode;
	
	@JsonProperty("message")
	private String httpErrorMessage;
	
	@JsonProperty("data")
	private ApiExceptionDataVO httpErrorResult;
	
	@Builder
	public ApiExceptionEntity(HttpStatus status, int httpErrorCode, String httpErrorMessage, ApiExceptionDataVO httpErrorResult) {
		this.httpErrorCode = httpErrorCode;
		this.httpErrorMessage = httpErrorMessage;
		this.httpErrorResult = httpErrorResult;
	}

		
}
