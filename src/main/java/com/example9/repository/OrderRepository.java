package com.example9.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example9.domain.Order;

/**
 * Orderを操作するリポジトリ.
 * @author mizuki.tanimori
 *
 */
@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**自動生成されたIDを簡単に取得できるSimpleJdbcInsertの変数宣言*/
	private SimpleJdbcInsert insert;
	
	/**
	 * OrderItemRepositoryがインスタンス化される時に1度だけ実行されるメソッド
	 * orderテーブルのidカラムが自動採番されることをDIコンテナ（Spring)に教えている
	 */
	@PostConstruct
	public void init() {
		//getJdbcOperations()はあまり使用されていないメソッドの呼び出しを許可するために、従来のSpring JdbcTemplate操作を公開する
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		//withTableNameは挿入に使用するテーブル名を指定
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order");
		//自動生成キーを持つ列の名前を指定
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	
	private ResultSetExtractor<List<Order>>RESULT_SET_EXTRACTOR=(rs)->{
		List<Order>orderList = new ArrayList<>();
		List<OrderItem>orderItemList;
		List<OrderTopping>orderToppingList;
		
		Integer orderIdOneBefore = 0;
		Integer orderItemIdOneBefore = 0;
		
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setUserId(rs.getInt("user_id"));
		
	}
	
}
