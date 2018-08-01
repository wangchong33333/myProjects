package com.mrwang.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ftl")
public class FtlController {

	@RequestMapping("hello")
	public String hello(Model model) {
		model.addAttribute("hello", "ftl");
		return "ftl";
	}
}
