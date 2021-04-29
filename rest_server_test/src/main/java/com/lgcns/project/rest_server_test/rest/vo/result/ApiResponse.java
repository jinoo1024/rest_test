package com.lgcns.project.rest_server_test.rest.vo.result;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class ApiResponse {
	
	public static final ResponseEntity<?> getSelectOneResult(Object obj) {
		return ResponseEntity
		        .status(HttpStatus.OK)
		        .body(ApiSelectOneEntity.builder()
		                .code(HttpStatus.OK.value())
		                .message(HttpStatus.OK.getReasonPhrase())
		                .result(ApiSelectOneDataVO.builder().resultCode("SUCCESS").resultMessage("").content(obj).build())
		                .build()); 
	}
	
	public static final ResponseEntity<?> getSelectAllResult(List<?> objList) {
		return ResponseEntity
	            .status(HttpStatus.OK)
	            .body(ApiSelectAllEntity.builder()
	                    .code(HttpStatus.OK.value())
	                    .message(HttpStatus.OK.getReasonPhrase())
	                    .result(ApiSelectAllDataVO.builder().resultCode("SUCCESS").resultMessage("").content(objList).build())
	                    .build());
	}
	
	public static final ResponseEntity<?> getInsertResult(String message) {
		return ResponseEntity
		        .status(HttpStatus.CREATED)
		        .body(ApiInsertEntity.builder()
		                .code(HttpStatus.CREATED.value())
		                .message(HttpStatus.CREATED.getReasonPhrase())
		                .result(ApiInsertDataVO.builder().resultCode("SUCCESS").resultMessage(message).build())
		                .build());
	}
	
	public static final ResponseEntity<?> getUpdateResult(String message) {
		return ResponseEntity
		        .status(HttpStatus.ACCEPTED)
		        .body(ApiUpdateEntity.builder()
		                .code(HttpStatus.ACCEPTED.value())
		                .message(HttpStatus.ACCEPTED.getReasonPhrase())
		                .result(ApiUpdateDataVO.builder().resultCode("SUCCESS").resultMessage(message).build())
		                .build());
	}
}
