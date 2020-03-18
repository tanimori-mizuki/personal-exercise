package com.example9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example9.domain.User;
import com.example9.form.LoginUserForm;
import com.example9.service.LoginService;

/**
 * ログインを行うコントローラーです.
 * @author mizuki.tanimori
 *
 */
@Controller
@RequestMapping("/")
public class LoginContoroller {

	@Autowired
	private LoginService loginService;
	
	@ModelAttribute
	public LoginUserForm setUpLoginUserForm() {
		return new LoginUserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(LoginUserForm form,Model model) {
		User user = loginService.login(form.getEmail(), form.getPassword());
		
		if(user == null) {	//	メールアドレス、パスワードがない場合
			String message = "メールアドレスまたはパスワードが不正です";
			model.addAttribute("message", message);
			return index();
		} 
		return "item_list_toy";
	}
}
