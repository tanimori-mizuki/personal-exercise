package com.example9.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example9.domain.Item;
import com.example9.domain.Order;
import com.example9.domain.OrderItem;
import com.example9.domain.OrderTopping;
import com.example9.domain.Topping;

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
	
}
