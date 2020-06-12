package org.kpu.web.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kpu.web.domain.BoardVO;
import org.kpu.web.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	@Around("execution(* org.kpu.web.controller..*Controller.*(..))"
			+ " or execution(* org.kpu.web.service..*Impl.*(..))"
			+ " or execution(* org.kpu.web.dao..*Imp.*(..))")
	
	public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String name ="";
		
		if(type.contains("Controller")) {
			name = "Controller : ";
		}else if(type.contains("Service")) {
			name = "service : ";
		}else if(type.contains("DAO")) {
			name = "DAO : ";
		}
		
		long end = System.currentTimeMillis();
		
		logger.info(name + type + "."+proceedingJoinPoint.getSignature().getName() + "()");
		logger.info("Argument/Parameter : " + Arrays.toString(proceedingJoinPoint.getArgs()));
		logger.info("Running Time : " + (end-start));
		logger.info("----------------------------------------------------------------");
			
		return result;
	}

}
