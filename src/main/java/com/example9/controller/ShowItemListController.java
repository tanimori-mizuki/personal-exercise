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
	
	/**
	 * 商品の一覧表示を行います.
	 * @param model
	 * @return　商品一覧表示
	 */
	@RequestMapping("/")
	public String showItemList(Model model){
		List<Item>itemList = showItemListService.showItemList();
		List<List<Item>>itemListList = new ArrayList<>();
		itemListList = getThreeItemList(itemList);
		model.addAttribute("itemListList", itemListList);
		return "item_list_toy";
	}
	
	/**
	 * 検索結果の一覧を表示します.
	 * @param code　入力された商品名
	 * @param model　リクエストスコープ
	 * @return　商品一覧表示
	 */
	@RequestMapping("/serch")
	public String showSerchByLikeName(String code, Model model){
		List<Item>itemList = showItemListService.showByLikeNameItemList(code);
		
		if(itemList.size() == 0) {
			String message = "検索結果がありません。";
			model.addAttribute("message", message);
		}
		List<List<Item>>itemListList = new ArrayList<>();
		itemListList = getThreeItemList(itemList);
		model.addAttribute("itemListList", itemListList);
		return "item_list_toy";
	}
	

	/**
	 * 3列表示をするためのメソッド
	 * @param itemList　アイテムリスト
	 * @return　itemListList
	 */
	private List<List<Item>> getThreeItemList(List<Item> itemList){
		List<List<Item>>itemListList = new ArrayList<>();
		List<Item>threeItemList = new ArrayList<>();
		
		for(int i = 1 ; i <= itemList.size() ; i++) {
			threeItemList.add(itemList.get(i-1));
			
			if(i % 3 == 0 || i == itemList.size()) {
				itemListList.add(threeItemList);
				threeItemList = new ArrayList<>();
			}
		}
		return itemListList;
	}
}
