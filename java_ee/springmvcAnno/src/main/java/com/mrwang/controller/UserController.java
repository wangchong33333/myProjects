package com.mrwang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String receiveInt(@RequestParam(defaultValue = "222", value = "ss", required = true) Integer id) {
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

	@RequestMapping("receiveUserCustomList")
	public String receiveUserCustomList(UserCustom user) {
		System.out.println(user);
		return "success";
	}

	@RequestMapping("receiveUserCustomMap")
	public String receiveUserCustomMap(UserCustom user) {
		System.out.println(user);
		return "success";
	}

	@RequestMapping("list")
	public String list(Model model) {
		List<User> list = new ArrayList<>();

		User user1 = new User();
		user1.setUsername("you");
		user1.setAddress("武汉");
		user1.setAge("12");
		user1.setBirthday(new Date());
		user1.setId(1);

		User user2 = new User();
		user2.setUsername("you2");
		user2.setAddress("武汉2");
		user2.setAge("122");
		user2.setBirthday(new Date());
		user2.setId(2);

		User user3 = new User();
		user3.setUsername("you3");
		user3.setAddress("武汉3");
		user3.setAge("123");
		user3.setBirthday(new Date());
		user3.setId(3);

		list.add(user1);
		list.add(user2);
		list.add(user3);
		model.addAttribute("userList", list);

		return "list";
	}

	@RequestMapping("update/{id}")
	public String update(@PathVariable Integer id) {
		System.out.println(id);
		return "redirect:/user/list.do";
	}

	@RequestMapping("forward")
	public String forward() {
		return "forward:/items/list.do";
	}

	@RequestMapping("redirect")
	public String redirect() {
		return "redirect:list.do";
	}

	@RequestMapping("toJson")
	public String toJson() {
		return "requestJson";
	}

	@RequestMapping("requestJson")
	public @ResponseBody User requestJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("requestPojo")
	public @ResponseBody User requestPojo(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("multiView")
	public User multiView() {
		User user1 = new User();
		user1.setUsername("you");
		user1.setAddress("武汉");
		user1.setAge("12");
		user1.setBirthday(new Date());
		user1.setId(1);

		return user1;
	}
}
