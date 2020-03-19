package com.example9.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example9.domain.Item;

/**
 * Itemを操作するリポジトリ―.
 * @author mizuki.tanimori
 *
 */
@Repository
public class ItemRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Itemオブジェクトを生成するローマッパー
	 */
	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs,i) ->{
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_l"));
		item.setImagePath(rs.getString("image_path"));
		return item;
	};

	/**
	 * 商品を全件検索します.(価格降順）
	 * @return　商品全件
	 */
	public List<Item> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,description,price_m,price_l,image_path,deleted ");
		sql.append("FROM items ");
		sql.append("ORDER BY price_m");
		return template.query(sql.toString(), ITEM_ROW_MAPPER);
	}
	
	/**
	 * idで商品を1件検索します.
	 * @param id　ID
	 * @return　1件の商品
	 */
	public Item findById(Integer id){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,description,price_m,price_l,image_path ");
		sql.append("FROM items ");
		sql.append("WHERE id=:id");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql.toString(), param, ITEM_ROW_MAPPER);
	}
}
