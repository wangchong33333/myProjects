package com.mrwang.springboot.controller;

import java.io.IOException;
import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrwang.springboot.utils.ServerUtil;
import com.mrwang.springboot.utils.jedis.JedisClient;

@Controller
public class HelloController {
	@Autowired
	private JedisClient jedisClient;

	@RequestMapping("hello")
	@ResponseBody
	public String hello() throws IOException {
		Long visits = jedisClient.incr("counter");
		InetAddress address = ServerUtil.getLocalHostLANAddressByDatagramSocket();
		// InetAddress address2 = ServerUtil.getLocalHostLANAddress2();
		return "hello world！雷猴啊,hostName:" + address.getLocalHost().toString() + ",访问次数：" + visits;
	}
}
