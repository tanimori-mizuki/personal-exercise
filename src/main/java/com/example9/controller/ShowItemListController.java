package com.example9.controller;

import java.util.ArrayList;
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
	
	@RequestMapping("/serch")
	public String showSerchByLikeName(String code, Model model){
		List<Item>itemList = showItemListService.showByLikeNameItemList(code);
		model.addAttribute("itemList", itemList);
		return "redirect:/item_list_toy";
	}
	
//	private List<Item> createThreeItemList(){
//		List<Item>itemList = showItemListService.showItemList();	//	itemの全件検索
//		int size = itemList.size();
//		List<Item>itemListList = new ArrayList<>();
//		// itemListの数になるまで繰り返す→itemListListに入れるのを
//		for(int i =0 ; i <= size ; i++) {
//			List<Item>threeItemList = new ArrayList<>();
//			if(size % 3 == 0 || size <= 3) {
//				threeItemList.add(itemList.get(i));
//			}
//			itemListList.addAll(threeItemList);
//		}
//		return itemListList;
//	}
}
