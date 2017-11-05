package com.mrwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrwang.domain.User;
import com.mrwang.domain.UserCustom;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String myHello() {
		return "hello";
	}

	@RequestMapping("toAdd")
	public String toAdd() {
		return "add";
	}

	@RequestMapping("receiveInt")
	public String receiveInt(Integer id) {
		System.out.println(id);
		return "success";
	}

	@RequestMapping("receiveStr")
	public String receiveStr(String username) {
		System.out.println(username);
		return "success";
	}

	@RequestMapping("receiveUser")
	public String receiveUser(User user) {
		System.out.println(user);
		return "success";
	}

	@RequestMapping("receiveUserCustom")
	public String receiveUserCustom(UserCustom user) {
		System.out.println(user);
		return "success";
	}

	@RequestMapping("receiveIds")
	public String receiveUserCustom(Integer[] ids) {
		System.out.println(ids);
		return "success";
	}
}
