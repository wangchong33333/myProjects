package com.mrwang.e_lifecycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("前方法" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean,
			String beanName) throws BeansException {
		System.out.println("后方法" + beanName);
		return Proxy.newProxyInstance(MyBeanPostProcessor.class
				.getClassLoader(), bean.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("开启事务");
						Object object = method.invoke(bean, args);
						System.out.println("提交事务");
						return object;
					}
				});
	}

}
