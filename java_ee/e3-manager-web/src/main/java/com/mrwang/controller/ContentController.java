package com.mrwang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrwang.common.utils.E3Result;
import com.mrwang.content.service.ContentService;
import com.mrwang.pojo.TbContent;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentServive;

	@RequestMapping(value = "/content/save", method = RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(TbContent content) {
		E3Result result = contentServive.addContent(content);
		return result;
	}
}
