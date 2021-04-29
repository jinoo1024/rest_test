package com.lgcns.project.rest_server_test.rest.vo.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiSelectAllDataVO {

	@JsonProperty("resultCode")
	private String resultCode;
	
	@JsonProperty("resultMessage")
	private String resultMessage;
	
	@JsonProperty("content")
	private List<?> content;
	
	@Builder
	public ApiSelectAllDataVO(String resultCode, String resultMessage, List<?> content) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.content = content;
	}
}
