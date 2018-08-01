package com.mrwang.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {
	public static UserServiceImpl creatService() {
		final UserServiceImpl userService = new UserServiceImpl();

		final MyAspect myAspect = new MyAspect();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(userService.getClass());
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				myAspect.before();
				Object object = method.invoke(userService, args);
				methodProxy.invokeSuper(proxy, args);
				myAspect.after();
				return object;
			}
		});

		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		return proxyService;
	}
}
