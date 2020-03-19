package com.example9.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example9.domain.Topping;

/**
 * Toppingを操作するリポジトリです.
 * @author mizuki
 *
 */
@Repository
public class ToppingRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Toppingオブジェクトを生成するロ―マッパー
	 */
	private static final RowMapper<Topping>TOPPING_ROW_MAPPER =(rs,i) ->{
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};
	
	/**
	 * 全件検索を行います.
	 * @return　トッピング全件
	 */
	public List<Topping> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,price_m,price_l ");
		sql.append("FROM toppings");
		return template.query(sql.toString(), TOPPING_ROW_MAPPER);
	}
	
}
