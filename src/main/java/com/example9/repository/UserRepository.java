package com.example9.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example9.domain.User;

/**
 * Userを操作するリポジトリー.
 * @author mizuki.tanimori
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Userドメインを生成するローマッパー.
	 */
	private static final RowMapper<User> USER_ROW_MAPPER = (rs,i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	
	/**
	 * ユーザー情報が入力されたら登録を行います.
	 * @param user　ユーザー情報
	 */
	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		System.out.println(user);
		String sql = "INSERT INTO users (name, email, password, zipcode, address, telephone)"
				   + " VALUES (:name, :email, :password, :zipcode, :address, :telephone)";
		template.update(sql, param);
	}
	
	
	/**
	 * メールアドレスとパスワードでユーザを検索します.
	 * 
	 * @param email　メール
	 * @param password　パスワード
	 * @return　1件のユーザ情報
	 */
	public User findByEmailAndPassword(String email, String password) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,email,password,zipcode,address,telephone ");
		sql.append("FROM users ");
		sql.append("WHERE email=:email and password=:password");
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		return template.queryForObject(sql.toString(), param, USER_ROW_MAPPER);
	}
}
