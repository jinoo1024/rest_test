package com.lgcns.project.rest_server_test.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.project.rest_server_test.rest.excpetion.ApiException;
import com.lgcns.project.rest_server_test.rest.excpetion.ExceptionEnum;
import com.lgcns.project.rest_server_test.rest.vo.TestVO;

import ch.qos.logback.classic.Logger;

@RestController
public class TestController {

	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	private Map<String, TestVO> testMap;
	
	@PostConstruct
	public void init() {
		testMap = new HashMap<String, TestVO>();
		testMap.put("1", new TestVO("1","Jinoo","jjw1024@gmail.com"));
		testMap.put("2", new TestVO("2","Jack","jact@naver.com"));
		testMap.put("3", new TestVO("3","Helen","hl1102@yahoo.com"));
	}
	
	@GetMapping("/test/{id}")
	public TestVO getTestInfo(@PathVariable String id) {
		int i = Integer.parseInt(id);
		logger.info("getTestInfo");
		/*
		if(1==1) {
			throw new ApiException(ExceptionEnum.UNAUTHORIZED);
		}
		*/
		return testMap.get(id);
	}
}
