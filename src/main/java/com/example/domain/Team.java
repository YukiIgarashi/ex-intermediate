package com.example.domain;

import java.util.Date;

public class Team {
	
	private String name;
	private String field;
	private Date birthDay;
	private String history;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", field=" + field + ", birthDay=" + birthDay + ", history=" + history + "]";
	}
	
	

}
