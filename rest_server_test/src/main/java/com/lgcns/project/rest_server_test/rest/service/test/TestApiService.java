package com.lgcns.project.rest_server_test.rest.service.test;

import java.util.List;
import java.util.Map;

import com.lgcns.project.rest_server_test.rest.vo.TestVO;

public interface TestApiService {

	TestVO getTestUserInfo(Map<String, Object> param);
	List<TestVO> getTestAllInfo(Map<String, Object> param);
	int insertTestUser(Map<String, Object> param);
	int updateTestUser(Map<String, Object> param);
	int deleteTestUser(Map<String, Object> param);
	int transactionTestUser();
	
}
