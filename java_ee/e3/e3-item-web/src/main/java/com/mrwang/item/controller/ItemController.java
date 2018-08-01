package com.mrwang.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrwang.item.pojo.Item;
import com.mrwang.pojo.TbItem;
import com.mrwang.pojo.TbItemDesc;
import com.mrwang.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		TbItem tbItem = itemService.getItemById(itemId);
		Item item = new Item(tbItem);

		TbItemDesc itemDesc = itemService.getItemDescById(itemId);

		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);

		return "item";
	}
}
