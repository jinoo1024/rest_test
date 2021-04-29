package com.lgcns.project.rest_server_test.rest.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lgcns.project.rest_server_test.rest.exception.ApiException;
import com.lgcns.project.rest_server_test.rest.exception.ApiExceptionDataVO;
import com.lgcns.project.rest_server_test.rest.exception.ApiExceptionEntity;
import com.lgcns.project.rest_server_test.rest.exception.ExceptionEnum;

import ch.qos.logback.classic.Logger;

@RestControllerAdvice
public class TestCommonControllerAdvice {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	@ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for ApiException.class");
        e.printStackTrace();
		return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiExceptionEntity.builder()
                        .httpErrorCode(e.getError().getCode())
                        .httpErrorMessage(e.getError().getMessage())
                        .httpErrorResult(e.getError().getData())
                        .build());
    }
	
	@ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for Exception.class");
		e.printStackTrace();
		return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiExceptionEntity.builder()
                        .httpErrorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .httpErrorMessage(ExceptionEnum.INTERNAL_SERVER_ERROR.getData().getResultMessage())
                        .httpErrorResult(ApiExceptionDataVO.builder().resultCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getData().getResultCode()).resultMessage(e.getMessage()).build())
                        .build());
    }
	
	@ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final MissingServletRequestParameterException e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for MissingServletRequestParameterException.class");
		e.printStackTrace();
		return ResponseEntity
				.status(ExceptionEnum.BAD_REQUEST.getStatus())
                .body(ApiExceptionEntity.builder()
                		.httpErrorCode(ExceptionEnum.BAD_REQUEST.getCode())
                        .httpErrorMessage(ExceptionEnum.BAD_REQUEST.getData().getResultMessage())
                        .httpErrorResult(ApiExceptionDataVO.builder().resultCode(ExceptionEnum.BAD_REQUEST.getData().getResultCode()).resultMessage(e.getMessage()).build())
                        .build());
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final HttpMessageNotReadableException e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for HttpMessageNotReadableException.class");
		e.printStackTrace();
		return ResponseEntity
				.status(ExceptionEnum.BAD_REQUEST_01.getStatus())
                .body(ApiExceptionEntity.builder()
                		.httpErrorCode(ExceptionEnum.BAD_REQUEST_01.getCode())
                        .httpErrorMessage(ExceptionEnum.BAD_REQUEST_01.getData().getResultMessage())
                        .httpErrorResult(ApiExceptionDataVO.builder().resultCode(ExceptionEnum.BAD_REQUEST_01.getData().getResultCode()).resultMessage(e.getMessage()).build())
                        .build());
	}
	
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final HttpRequestMethodNotSupportedException e) {
		
		logger.info("TestCommonControllerAdvice.exceptionHandler for HttpRequestMethodNotSupportedException.class");
		e.printStackTrace();
		return ResponseEntity
				.status(ExceptionEnum.BAD_REQUEST_02.getStatus())
                .body(ApiExceptionEntity.builder()
                		.httpErrorCode(ExceptionEnum.BAD_REQUEST_02.getCode())
                        .httpErrorMessage(ExceptionEnum.BAD_REQUEST_02.getData().getResultMessage())
                        .httpErrorResult(ApiExceptionDataVO.builder().resultCode(ExceptionEnum.BAD_REQUEST_02.getData().getResultCode()).resultMessage(e.getMessage()).build())
                        .build());
	}
}
