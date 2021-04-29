package com.lgcns.project.rest_server_test.rest.vo.result;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiSelectAllEntity {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private ApiSelectAllDataVO result;
	
	@Builder
	public ApiSelectAllEntity(HttpStatus status, int code, String message, ApiSelectAllDataVO result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}
}
