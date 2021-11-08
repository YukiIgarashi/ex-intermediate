package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * DBからチーム情報を検索する用のレポジトリクラス
 * @author igayuki
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 *DBから抽出のデータをチームオブジェクトに詰め替える 
	 */
	private static final RowMapper<Team> TEAM_ROW_MAPPER
		= (rs,i)->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquartes(rs.getString("headquarters"));
		team.setInaguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		
		return team;
	};
	
	
	
	/**
	 * 全件検索
	 * @return
	 */
	public List<Team> findAll() {
		
		String sql = "SELECT * FROM teams ORDER BY inauguration ASC;";
		
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		
		return teamList;
	}
	
	/**
	 * 引数で受けたidのチームを1件検索
	 * @param id　検索したいチームID
	 * @return　検索結果のチームオブジェクト
	 */
	public Team findById(Integer id) {
		
		String sql = "SELECT * FROM teams WHERE id = :id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Team team = template.queryForObject(sql, param ,TEAM_ROW_MAPPER);
		
		return team;
		
	}

}
