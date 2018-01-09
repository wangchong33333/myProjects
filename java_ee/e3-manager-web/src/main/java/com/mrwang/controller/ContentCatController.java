package com.mrwang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrwang.common.pojo.EasyUITreeNode;
import com.mrwang.common.utils.E3Result;
import com.mrwang.content.service.ContentCatService;

@Controller
public class ContentCatController {
	@Autowired
	private ContentCatService contentCatService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
		List<EasyUITreeNode> list = contentCatService.getCosntentCatList(parentId);
		return list;
	}

	@RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
	@ResponseBody
	public E3Result createContentCat(Long parentId, String name) {
		E3Result result = contentCatService.addContentCat(parentId, name);
		return result;
	}
}
