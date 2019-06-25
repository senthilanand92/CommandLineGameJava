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
	private Long fightHealth;
	
	
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
	
	public void addExperiencePoints(Long expPoints){
		this.experience+=expPoints;
		
	}
	public void resetHealth(){
		this.fightHealth=Health;
	}

	@Override
	public String toString() {
		return "Player [character=" + character + ", experience=" + experience + ", Health=" + Health + ", Strength="
				+ Strength + "]";
	}
	
	public Long getFightHealth() {
		return fightHealth;
	}


	public void setFightHealth(Long fightHealth) {
		this.fightHealth = fightHealth;
	}
	
	public void printStats(boolean isFightMode){
		Long health=isFightMode?fightHealth:Health;
		System.out.println("Player:"+character.getName()+" Stats-> Health:"+
				health+" Strength:"+Strength+" Experience Points:"+experience);
	}
	

	

}
