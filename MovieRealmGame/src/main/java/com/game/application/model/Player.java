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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Health == null) ? 0 : Health.hashCode());
		result = prime * result + ((Strength == null) ? 0 : Strength.hashCode());
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((fightHealth == null) ? 0 : fightHealth.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (Health == null) {
			if (other.Health != null)
				return false;
		} else if (!Health.equals(other.Health))
			return false;
		if (Strength == null) {
			if (other.Strength != null)
				return false;
		} else if (!Strength.equals(other.Strength))
			return false;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (fightHealth == null) {
			if (other.fightHealth != null)
				return false;
		} else if (!fightHealth.equals(other.fightHealth))
			return false;
		return true;
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
