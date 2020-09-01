package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[BEFORE] ����Ͻ� �޼ҵ� ���� ���� ó���� ����...");
		Object returnobj = pjp.proceed();
		System.out.println("[AFTER] ����Ͻ� �޼ҵ� ���� �Ŀ� ó���� ����");
		return returnobj;
	}
}
