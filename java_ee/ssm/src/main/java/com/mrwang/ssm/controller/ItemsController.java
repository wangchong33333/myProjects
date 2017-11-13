package com.mrwang.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrwang.ssm.domain.Items;
import com.mrwang.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Resource
	private ItemsService itemsService;

	@RequestMapping("list.do")
	public String list(Model model) {
		List<Items> list = itemsService.findAll();
		model.addAttribute("itemsList", list);
		return "itemsList";
	}

	@RequestMapping("edit")
	public String edit(Integer id, Model model) {
		Items items = itemsService.findByID(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items){
		itemsService.saveOrUpdate(items);
		return "redirect:list.do";
	}
}
