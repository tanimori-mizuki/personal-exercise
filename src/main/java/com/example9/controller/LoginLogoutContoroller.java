package com.example9.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example9.domain.User;
import com.example9.form.LoginUserForm;
import com.example9.service.LoginService;

/**
 * ログインとログアウトを行うコントローラーです.
 * @author mizuki.tanimori
 *
 */
@Controller
@RequestMapping("/login")
public class LoginLogoutContoroller {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public LoginUserForm setUpLoginUserForm() {
		return new LoginUserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/user_login")
	public String login(LoginUserForm form,Model model) {
		User user = loginService.login(form.getEmail(), form.getPassword());
		
		if(user == null) {	//	メールアドレス、パスワードがない場合
			String message = "メールアドレスまたはパスワードが不正です";
			model.addAttribute("message", message);
		} 
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/login";
	}
}
