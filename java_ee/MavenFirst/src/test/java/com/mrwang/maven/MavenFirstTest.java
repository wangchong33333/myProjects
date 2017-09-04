package com.mrwang.maven;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MavenFirstTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testSayHello() {
		MavenFirst mavenFirst=new MavenFirst();
		String sayHello = mavenFirst.sayHello("mrwang");
		Assert.assertEquals("hello mrwang", sayHello);
	}

}
