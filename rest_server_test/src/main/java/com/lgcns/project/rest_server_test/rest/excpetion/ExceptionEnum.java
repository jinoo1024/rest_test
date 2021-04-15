package com.lgcns.project.rest_server_test.rest.excpetion;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,  "E00001", "Internal Server Error"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E00002", "Unauthorized");
	
	private HttpStatus status;
	private String code;
	private String message;
	
	ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
