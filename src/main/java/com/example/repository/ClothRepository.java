package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;
import com.example.domain.Hotel;

/**
 * 
 * @author igayuki
 *
 */
@Repository
public class ClothRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER
	=(rs,i) -> {
		Cloth cloth= new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 性別と色を条件に検索を行なうメソッド
	 * @param gender　HTMLで入力され、コントローラー、サービスに送られる性別
	 * @param color　同・色
	 * @return　検索に応じたオブジェクトリスト
	 */
	public List<Cloth> findByGenderAndColor(Integer gender,String color) {
		
		String sql = "SELECT * FROM clothes "
				+ "WHERE gender = :gender And color = :color;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
		
		return clothList;
		
	}

}
