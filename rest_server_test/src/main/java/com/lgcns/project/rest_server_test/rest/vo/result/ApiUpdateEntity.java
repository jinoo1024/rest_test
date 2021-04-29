package com.lgcns.project.rest_server_test.rest.vo.result;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiUpdateEntity {

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private ApiUpdateDataVO result;
	
	@Builder
	public ApiUpdateEntity(HttpStatus status, int code, String message, ApiUpdateDataVO result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}
}
