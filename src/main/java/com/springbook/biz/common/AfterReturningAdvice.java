package com.springbook.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
	}
}
