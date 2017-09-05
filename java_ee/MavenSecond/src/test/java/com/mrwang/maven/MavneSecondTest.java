package com.mrwang.maven;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MavneSecondTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSayHello() {
		MavneSecond mavneSecond=new MavneSecond();
		String sayHello = mavneSecond.sayHello("mrwang");
		Assert.assertEquals("hello mrwang", sayHello);
	}

}
