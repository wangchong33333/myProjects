package com.mrwang.d_aspect.b_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* com.mrwang.d_aspect.b_anno.UserServiceImpl.*(..))")
	private void myPointCut() {
	}

	// @Before("execution(* com.mrwang.d_aspect.b_anno.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知" + joinPoint.getSignature().getName());
	}

	// @AfterReturning(value = "myPointCut()", returning = "ret")
	public void myAfterRrturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知" + joinPoint.getSignature().getName() + ",返回值"
				+ ret);
	}

	@Around(value = "myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		System.out.println("前");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("后");
		return obj;
	}

	@AfterThrowing(value = "myPointCut()", throwing = "e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e)
			throws Throwable {
		System.out.println("抛出异常" + e.getMessage());
	}

	@After(value = "myPointCut()")
	public void myAfter() {
		System.out.println("最终通知");
	}

}
