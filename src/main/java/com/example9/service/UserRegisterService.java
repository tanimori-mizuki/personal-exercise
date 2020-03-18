package com.example9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.domain.User;
import com.example9.repository.UserRepository;

/**
 * ユーザ登録を行うサービスクラスです.
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class UserRegisterService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ユーザ登録を行います.
	 * @param user　ユーザ情報
	 * @return　ユーザ情報
	 */
	public void insert(User user) {
		userRepository.insert(user);
	}
	
}
