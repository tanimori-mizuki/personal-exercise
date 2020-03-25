package com.example9.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example9.domain.Item;
import com.example9.domain.Topping;
import com.example9.service.ShowItemDetailService;

@Controller
@RequestMapping("/itemDetail")
public class ShowItemDetailContoroller {

	@Autowired
	private ShowItemDetailService showItemDetailService;
	
	@RequestMapping("")
	public String showItemDetail(Model model, Integer id) {
		
		List<Topping>topping = showItemDetailService.findAll();	 //Toppingの全件検索
		Item item = showItemDetailService.findById(id);             //itemのid検索
		item.setToppingList(topping);                                        //検索したidのitemのitemListの中にToppingを入れる
		model.addAttribute("item", item);
		//Toppingの価格はHTMLのth:eachで回せないのでkeyを付けてリクエストスコープに格納する
		//どれか1件分の価格が表示できればいいので、Toppingリストの0番目の価格を取得する
		model.addAttribute("toppingPriceM", topping.get(0).getPriceM());   
		model.addAttribute("toppingPriceL", topping.get(0).getPriceL());    
		
		return "item_detail";
	}
	
}
