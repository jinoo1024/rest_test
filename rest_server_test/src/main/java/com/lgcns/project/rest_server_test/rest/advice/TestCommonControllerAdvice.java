package com.lgcns.project.rest_server_test.rest.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lgcns.project.rest_server_test.rest.excpetion.ApiException;
import com.lgcns.project.rest_server_test.rest.excpetion.ApiExceptionEntity;

import ch.qos.logback.classic.Logger;

@RestControllerAdvice
public class TestCommonControllerAdvice {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for ApiException.class");
        
		return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .errorMessage(e.getError().getMessage())
                        .build());
    }
}