package com.example9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.domain.Item;
import com.example9.repository.ItemRepository;

/**
 * 商品を検索するサービスクラスです.
 * @author mizuki
 *
 */
@Service
@Transactional
public class ShowItemListService {

	@Autowired
	private ItemRepository itemRepository;
	
	/**
	　 * 商品の全件検索を行います.
	 * @return　商品全件
	 */
	public List<Item> showItemList(){
		return itemRepository.findAll();
	}
	
	/**
	 * 商品名で曖昧検索を行います.
	 * @param name　名前
	 * @return　検索された商品
	 */
	public List<Item> showByLikeNameItemList(String name){
		return itemRepository.findByLikeName(name);
	}
}
