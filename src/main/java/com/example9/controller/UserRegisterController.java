package com.example9.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example9.domain.User;
import com.example9.form.RegisterUserForm;
import com.example9.service.UserRegisterService;


/**
 * ユーザ情報を登録するコントローラーです.
 * @author mizuki.tanimori
 *
 */
@Controller
@RequestMapping("/register")
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@ModelAttribute
	public RegisterUserForm setRegisterUpForm() {
		return new RegisterUserForm();
	}

	@RequestMapping("")
	public String  index() {
		return "register_user";
	}
	
	@RequestMapping("/insert")
	public String insert(RegisterUserForm form) {
		// formオブジェクトからuserオブジェクトにプロパティ値をコピー
		User user = new User();
		BeanUtils.copyProperties(form, user);
		userRegisterService.insert(user);	//user情報の登録
		return index();
	}
}
