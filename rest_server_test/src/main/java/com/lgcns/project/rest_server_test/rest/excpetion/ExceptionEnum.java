package com.lgcns.project.rest_server_test.rest.excpetion;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,  HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
	
	private HttpStatus status;
	private int code;
	private String message;
	
	ExceptionEnum(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
