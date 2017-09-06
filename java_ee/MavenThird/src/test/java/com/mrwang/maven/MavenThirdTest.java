package com.mrwang.maven;

import junit.framework.Assert;

import org.junit.Test;

public class MavenThirdTest {

	@Test
	public void test() {
		MavenThird mavenThird = new MavenThird();
		String sayHello = mavenThird.sayHello("mrwang");
		Assert.assertEquals("hello mrwang", sayHello);
	}

}
