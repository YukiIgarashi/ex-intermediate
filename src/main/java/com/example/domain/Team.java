package com.example.domain;

import java.util.Date;

public class Team {
	
	private Integer id;
	private String leagueName;
	private String teamName;
	private String headquartes;
	private String inaguration;
	private String history;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquartes() {
		return headquartes;
	}
	public void setHeadquartes(String headquartes) {
		this.headquartes = headquartes;
	}
	public String getInaguration() {
		return inaguration;
	}
	public void setInaguration(String inaguration) {
		this.inaguration = inaguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquartes="
				+ headquartes + ", inaguration=" + inaguration + ", history=" + history + "]";
	}
	
	
	

}
