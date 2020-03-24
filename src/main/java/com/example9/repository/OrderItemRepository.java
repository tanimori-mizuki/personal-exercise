package com.example9.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example9.domain.OrderItem;

/**
 * オーダーアイテムを操作するためのリポジトリです.
 * @author mizuki.tanimori
 *
 */
@Repository
public class OrderItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**「自動生成されたID」を簡単に取得することができるSimpleJdbcInsertクラスをフィールド変数として宣言*/
	private SimpleJdbcInsert insert;
	
	/**
	 * OrderItemRepositoryがインスタンス化される時に1度だけ実行されるメソッド
	 * order_itemsテーブルのidカラムが自動採番されることをDIコンテナ（Spring)に教えている
	 */
	@PostConstruct 
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert
		= new SimpleJdbcInsert((JdbcTemplate)template.getJdbcOperations());
		SimpleJdbcInsert withTableName
			= simpleJdbcInsert.withTableName("order_items");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	
	/**
	 * OrderItemをDBにインサートする
	 * @param orderItem　orderItemオブジェクト
	 * @return　自動採番されたidを含むorderItemオブジェクト
	 */
	public OrderItem insertOrderItem(OrderItem orderItem) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
		
		if(orderItem.getId() == null) {
			//自動採番されたIDがNumberオブジェクトとして返ってくるのでkey変数で受け取る
			Number key = insert.executeAndReturnKey(param);
			//Numberオブジェクト内の自動採番されたIDをint型に変換し、OrderItemオブジェクトに返す
			orderItem.setId(key.intValue());
		} else {
			String sql = "INSERT INTO order_item (item_id,order_id,quantity,size) VALUES (:itemId,:orderId,:quantity,:size)";
			template.update(sql, param);
		}
		return orderItem;
	}

	
}
