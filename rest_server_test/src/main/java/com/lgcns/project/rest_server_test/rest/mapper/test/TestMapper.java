package com.lgcns.project.rest_server_test.rest.mapper.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lgcns.project.rest_server_test.rest.vo.TestVO;

@Repository
@Mapper
public interface TestMapper {

	TestVO getTestUserInfo(Map<String, Object> param);
	List<TestVO> getTestAllInfo(Map<String, Object> param);
	int insertTestUser(Map<String, Object> param);
	int updateTestUser(Map<String, Object> param);
	int deleteTestUser(Map<String, Object> param);
}
