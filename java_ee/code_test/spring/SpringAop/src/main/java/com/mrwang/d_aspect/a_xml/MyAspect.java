package com.mrwang.d_aspect.a_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知" + joinPoint.getSignature().getName());
	}

	public void myAfterRrturning(JoinPoint joinPoint, Object ret) {
		System.out.println("后置通知" + joinPoint.getSignature().getName() + ",返回值"
				+ ret);
	}

	public Object myAround(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		System.out.println("前");
		Object obj = proceedingJoinPoint.proceed();
		System.out.println("后");
		return obj;
	}

	public void myAfterThrowing(JoinPoint joinPoint, Throwable e)
			throws Throwable {
		System.out.println("抛出异常" + e.getMessage());
	}
	
	public void myAfter(){
		System.out.println("最终通知");
	}

}
