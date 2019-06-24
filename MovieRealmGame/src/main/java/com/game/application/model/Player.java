package com.game.application.model;

import java.io.Serializable;

public class Player implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4381365719081611402L;

	// Character should never be allowed to change in the game
	final private PlayerCharacter character;
	
	private Long experience;
	private Long Health;
	private Long Strength;
	
	
	public Player(PlayerCharacter pCharacter) {
		this.character = pCharacter;
	}
	
	
	public PlayerCharacter getCharacter() {
		return character;
	}
	public Long getExperience() {
		return experience;
	}
	public void setExperience(Long experience) {
		this.experience = experience;
	}
	public Long getHealth() {
		return Health;
	}
	public void setHealth(Long health) {
		Health = health;
	}
	public Long getStrength() {
		return Strength;
	}
	public void setStrength(Long strength) {
		Strength = strength;
	}


	@Override
	public String toString() {
		return "Player [character=" + character + ", experience=" + experience + ", Health=" + Health + ", Strength="
				+ Strength + "]";
	}
	

}
