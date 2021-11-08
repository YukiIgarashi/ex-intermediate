package com.example.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * DBアクセス用レポジトリクラス
 * @author igayuki
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
		=(rs,i) -> {
			Hotel hotel = new Hotel();
			hotel.setId(rs.getInt("id"));
			hotel.setAreaName(rs.getString("area_name"));
			hotel.setAddress(rs.getString("address"));
			hotel.setNearestStation(rs.getString("nearest_station"));
			hotel.setPrice(rs.getInt("price"));
			hotel.setParking(rs.getString("parking"));
			return hotel;
		};
		
		/**
		 * 引数で受け取った価格以下のホテル情報を検索するメソッド
		 * @param price　検索欄に入力された価格
		 * @return　検索条件に合うHotelオブジェクト
		 */
		public List<Hotel> findByPrice(Integer price) {
			
			String sql = "SELECT * FROM hotels WHERE price <= :price;";
			
			SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
			
			List<Hotel> hotelList = template.query(sql,param, HOTEL_ROW_MAPPER);
			
			return hotelList;
		}
		
		/**
		 * 引数がなく全件検索するメソッド
		 * @return　Hotelオブジェクト全件
		 */
		public List<Hotel> findByPrice() {
			
			String sql = "SELECT * FROM hotels;";
			
			List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
			
			return hotelList;
		}

}
