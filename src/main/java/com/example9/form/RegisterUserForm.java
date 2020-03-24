package com.example9.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RegisterUserForm {

	/** 名前 */
	@NotBlank(message="お名前を入力してください")
	private String name;
	/** メール */
	@Email(message="アドレスが不正です")
	@NotBlank(message="メールアドレスを入力してください")
	private String email;
	/** パスワード */
	@NotBlank(message="パスワードを入力してください")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[0-9])[!-~] {8,20}$",message="パスワードを入力してください")
	private String password;
	/** 郵便番号 */
	@NotBlank(message="郵便番号を入力してください")
	@Pattern(regexp="^[0-9] {7}$",message="郵便番号はハイフン無の7桁で入力してください")
	private String zipcode;
	/** 住所 */
	@NotBlank(message="住所を入力してください")
	private String address;
	/** 電話番号 */
	@NotBlank(message="電話番号を入力してください")
	@Pattern(regexp="^[0-9]+$",message="電話番号は数値を入力してください")
	private String telephone;
	
	
	@Override
	public String toString() {
		return "RegisterUserForm [name=" + name + ", email=" + email + ", password=" + password + ", zipcode=" + zipcode
				+ ", address=" + address + ", telephone=" + telephone + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
