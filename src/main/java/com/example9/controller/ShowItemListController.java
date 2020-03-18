package com.example9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example9.domain.Item;
import com.example9.service.ShowItemListService;

@Controller
@RequestMapping("")
public class ShowItemListController {

	@Autowired
	private ShowItemListService showItemListService;
	
	@RequestMapping("/")
	public String showItemList(Model model){
		List<Item>itemList = showItemListService.showItemList();
		model.addAttribute("itemList", itemList);
		return "item_list_toy";
	}
}
