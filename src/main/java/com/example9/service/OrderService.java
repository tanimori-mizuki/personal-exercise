package com.example9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.repository.OrderItemRepository;
import com.example9.repository.OrderToppingRepository;

/**
 * 注文を処理するサービスクラス.
 * @author mizuki
 *
 */
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderToppingRepository orderToppingRepository;
	
	
	
}
