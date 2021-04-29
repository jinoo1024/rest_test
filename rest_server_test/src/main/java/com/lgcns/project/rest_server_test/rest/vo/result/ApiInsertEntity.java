package com.lgcns.project.rest_server_test.rest.vo.result;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiInsertEntity {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private ApiInsertDataVO result;
	
	@Builder
	public ApiInsertEntity(HttpStatus status, int code, String message, ApiInsertDataVO result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}
}
