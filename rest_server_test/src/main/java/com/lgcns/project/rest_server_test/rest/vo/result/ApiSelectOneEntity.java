package com.lgcns.project.rest_server_test.rest.vo.result;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiSelectOneEntity {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private ApiSelectOneDataVO result;
	
	@Builder
	public ApiSelectOneEntity(HttpStatus status, int code, String message, ApiSelectOneDataVO result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}
}
