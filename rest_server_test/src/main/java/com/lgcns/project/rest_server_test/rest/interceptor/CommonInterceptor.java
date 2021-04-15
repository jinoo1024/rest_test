package com.lgcns.project.rest_server_test.rest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

public class CommonInterceptor implements HandlerInterceptor  {

	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
	{
		logger.info("******************** CommonInterceptor.preHandle ****************************");
		logger.info("preHandle.status : " + response.getStatus());
		logger.info("preHandle.getDispatcherType = " + request.getDispatcherType().name());
		return true;
	}

	@Override
	//500에러 발생시 실행되지 않는다. afterCompletion가 바로 실행되는 것 같음
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		logger.info("******************** CommonInterceptor.postHandle ****************************");
		logger.info("postHandle.status : " + response.getStatus());
		logger.info("postHandle.getDispatcherType = " + request.getDispatcherType().name());
		
		
	}
	
	@Override
	//business controller에서 실행되지 않는 404 에러 등을 처리 한다.
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		logger.info("******************** CommonInterceptor.afterCompletion ****************************");
		logger.info("afterCompletion.status : " + response.getStatus());
		logger.info("afterCompletion.getDispatcherType = " + request.getDispatcherType().name());
	}
}
