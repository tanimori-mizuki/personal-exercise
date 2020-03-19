package com.example9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.domain.Item;
import com.example9.domain.Topping;
import com.example9.repository.ItemRepository;
import com.example9.repository.ToppingRepository;

/**
 * 商品詳細を操作するサービスクラスです.
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class ShowItemDetailService {

	@Autowired
	private ToppingRepository toppingRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 商品詳細を全件検索します.
	 * @return　商品詳細
	 */
	public List<Topping> findAll(){
		return toppingRepository.findAll();
	}
	
	/**
	 * IDで商品検索を行います.
	 * @param id ID
	 * @return　1件の商品
	 */
	public Item findById(Integer id) {
		return itemRepository.findById(id);
	}
}
