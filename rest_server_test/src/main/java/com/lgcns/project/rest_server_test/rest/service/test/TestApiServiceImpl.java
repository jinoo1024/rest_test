package com.lgcns.project.rest_server_test.rest.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lgcns.project.rest_server_test.rest.mapper.test.TestMapper;
import com.lgcns.project.rest_server_test.rest.vo.TestVO;

@Service
@Transactional
public class TestApiServiceImpl implements TestApiService{

	@Autowired
	private TestMapper testmapper;
	
	@Override
	public TestVO getTestUserInfo(Map<String, Object> param) {
		return testmapper.getTestUserInfo(param);
	}

	@Override
	public List<TestVO> getTestAllInfo(Map<String, Object> param) {
		return testmapper.getTestAllInfo(param);
	}

	@Override
	public int insertTestUser(Map<String, Object> param) {
		return testmapper.insertTestUser(param);
	}

	@Override
	public int updateTestUser(Map<String, Object> param) {
		return testmapper.updateTestUser(param);
	}

	@Override
	public int deleteTestUser(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int transactionTestUser() {
		
		TestVO testvo1 = new TestVO();
		testvo1.setUserId("user12");
		testvo1.setUserNm("트랜젝션사용아10");
		testvo1.setEmail("trans@naver.com");
		testvo1.setSeq(10);
		
		Map<String, Object> param = new HashMap<>();
		param.put("user", testvo1);
		
		testmapper.insertTestUser(param);
			
		TestVO testvo2 = new TestVO();
		testvo2.setUserId("user20");
		testvo2.setUserNm("트랜젝션사용아20");
		testvo2.setEmail("trans20@naver.com");
		testvo2.setSeq(20);
		
		param.put("user", testvo2);
		
		testmapper.updateTestUser(param);
		
		return 0;
	}	 
}
