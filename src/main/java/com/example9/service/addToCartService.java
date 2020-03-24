package com.example9.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.repository.ItemRepository;
import com.example9.repository.OrderItemRepository;
import com.example9.repository.OrderToppingRepository;

@Service
@Transactional
public class addToCartService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderToppingRepository orderToppingRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private HttpSession session;
	
}
