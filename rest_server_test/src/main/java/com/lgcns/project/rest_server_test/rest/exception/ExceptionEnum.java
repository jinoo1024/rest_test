package com.lgcns.project.rest_server_test.rest.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), new ApiExceptionDataVO("E00001", "User Internal Server Error")),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), ApiExceptionDataVO.builder().resultCode("E00002").resultMessage("User Unauthorized").build()),
	BAD_REQUEST(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new ApiExceptionDataVO("E00003", "User Bad Request")),
	BAD_REQUEST_01(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new ApiExceptionDataVO("E00004", "User Bad Request")),
	BAD_REQUEST_02(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new ApiExceptionDataVO("E00005", "User Bad Request"));
	
	private HttpStatus status;
	private int code;
	private String message;
	private ApiExceptionDataVO data;
	
	ExceptionEnum(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    
    ExceptionEnum(HttpStatus status, int code, String message, ApiExceptionDataVO data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
