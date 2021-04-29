package com.lgcns.project.rest_server_test.rest.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionDataVO {

	@JsonProperty("resultCode")
	private String resultCode;
	
	@JsonProperty("resultMessage")
	private String resultMessage;
	
	@Builder
	public ApiExceptionDataVO(String resultCode, String resultMessage) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	
}
