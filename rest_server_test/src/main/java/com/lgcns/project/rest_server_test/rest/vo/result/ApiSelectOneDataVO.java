package com.lgcns.project.rest_server_test.rest.vo.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiSelectOneDataVO {

	@JsonProperty("resultCode")
	private String resultCode;
	
	@JsonProperty("resultMessage")
	private String resultMessage;
	
	@JsonProperty("content")
	private Object content;
	
	@Builder
	public ApiSelectOneDataVO(String resultCode, String resultMessage, Object content) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.content = content;
	}
}
