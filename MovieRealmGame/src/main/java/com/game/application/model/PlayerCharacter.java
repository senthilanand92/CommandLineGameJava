package com.game.application.model;

import java.io.Serializable;

final public class PlayerCharacter implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5452586406372535961L;
	private String name;
	 private String title;
	 private String gender;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public String getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "PlayerCharacter [name=" + name + ", title=" + title + ", gender=" + gender + "]";
	}
	
}
