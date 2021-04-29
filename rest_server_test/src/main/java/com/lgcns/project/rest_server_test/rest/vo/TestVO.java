package com.lgcns.project.rest_server_test.rest.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestVO {

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("seq")
	private int seq;
	
	@JsonProperty("userNm")
	private String userNm;
	
	@JsonProperty("email")
	private String email;
	
	//@JsonIgnore
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("regDate")
	private String regDate;
	
	//@JsonIgnore
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("modDate")
	private String modDate;
	
}
