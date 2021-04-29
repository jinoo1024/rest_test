package com.lgcns.project.rest_server_test.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.project.rest_server_test.rest.service.test.TestApiService;
import com.lgcns.project.rest_server_test.rest.vo.TestVO;
import com.lgcns.project.rest_server_test.rest.vo.result.ApiResponse;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "first test controller V1")
public class TestController {

	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TestApiService testApiService;
	
	@PostConstruct
	public void init() {
	}
	
	@ApiOperation(value="search one user", notes="사용자 정보 조회 by 아이디 예제 입니다.")
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getTestUserInfo(@ApiParam(value = "사용자 아이디", required = true, example = "user01") @PathVariable String id) {
		logger.info("getTestUserInfo");
		
		/*
		try {
			logger.info("********* sleep start***************");
			Thread.sleep(10000);
			logger.info("********* sleep end***************");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		Map<String, Object> param = new HashMap<>();
		param.put("userId", id);
		
		TestVO test = testApiService.getTestUserInfo(param);
		
		/*
		if(1==1) {
			throw new ApiException(ExceptionEnum.UNAUTHORIZED);
		}
		*/
		
		return ApiResponse.getSelectOneResult(test);
	}
	
	@ApiOperation(value="search users", notes="사용자 정보 조회 예제 입니다.")
	@GetMapping("/users/all")
	public ResponseEntity<?> getTestAllInfo(@ApiParam(value = "사용자이름", required = true, example = "홍길동") @RequestParam String userNm) {
		logger.info("getTestAllInfo");
		
		Map<String, Object> param = new HashMap<>();
		param.put("userNm", userNm);
		
		List<TestVO> testList = testApiService.getTestAllInfo(param);
		
		return ApiResponse.getSelectAllResult(testList);
	}
	
	@ApiOperation(value="insert one user", notes="사용자 등록")
	@PutMapping("/users")
	public ResponseEntity<?> insertTestUser(@RequestBody TestVO user) {
		logger.info("insertTestUser");
		
		Map<String, Object> param = new HashMap<>();
		param.put("user", user);
		
		int cnt = testApiService.insertTestUser(param);
		
		if(cnt == 1) {
			return ApiResponse.getInsertResult("");
		}else {
			return null; //Exception 핸들링 해야 함
		}
	}
	
	@ApiOperation(value="update one user", notes="사용자 수정")
	@PostMapping("/users/{userId}")
	public ResponseEntity<?> updateTestUser(@ApiParam(value = "사용자아이디", required = true, example = "user01") @PathVariable String userId, @RequestBody TestVO user) {
		logger.info("updateTestUser");
		
		Map<String, Object> param = new HashMap<>();

		user.setUserId(userId);
		param.put("user", user);
		
		int cnt = testApiService.updateTestUser(param);
		
		if(cnt == 1) {
			return ApiResponse.getUpdateResult("");
		}else {
			return null; //Exception 핸들링 해야 함
		}
	}
	
	@PostMapping("/users/transaction")
	public void transactionTestUser(@RequestBody TestVO user) {
		logger.info("transactionTestUser");
		
		testApiService.transactionTestUser();
	}
}
