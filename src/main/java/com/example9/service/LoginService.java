package com.example9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example9.domain.User;
import com.example9.repository.UserRepository;

/**
 * ログインを行うサービスクラスです.
 * @author mizuki.tanimori
 *
 */
@Service
@Transactional
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * ログインを行います.
	 * @param email メールアドレス
	 * @param password　パスワード
	 * @return　ユーザ情報
	 */
	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
