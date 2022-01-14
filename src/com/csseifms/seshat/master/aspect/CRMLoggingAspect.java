package com.csseifms.seshat.master.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Pointcut("execution (* com.csseifms.seshat.master.controller.*.*(..))")
	private void forControllerPKG() {
		
	}
	@Pointcut("execution (* com.csseifms.seshat.master.dao.*.*(..))")
	private void forDAOPKG() {
		
	}
	@Pointcut("execution (* com.csseifms.seshat.master.service.*.*(..))")
	private void forServicePKG() {
		
	}
	
	@Pointcut("forControllerPKG() || forServicePKG() || forDAOPKG()")
	private void forAppFlow() {
		
	}
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("===> in before method AOP. calling method: " + theMethod);
	
		Object[] args = theJoinPoint.getArgs();
		for(Object arg:args) {
			logger.info("Logging Args: " + arg);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning ="returned")
	private void afterReturning(JoinPoint theJoinPoint, Object returned) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info("===> in afterReturning method AOP. calling method: " + theMethod);
	
		logger.info("===> returned result: " + returned.toString());

		
	}
	
	
}
