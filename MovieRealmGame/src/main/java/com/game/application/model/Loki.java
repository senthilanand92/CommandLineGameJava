package com.game.application.model;

public class Loki extends Enemy{

	@Override
	public void setHealth(Long health) {
		this.health=health;
	}
	
	public Loki(){
		this.strength=25L;
		this.expPoints=5L;
		this.health= 50L;	
		this.name="Loki";
	}


	@Override
	public void attack(boolean isDefenceSuccessful, Player player) {
		if(!isDefenceSuccessful){
			player.setFightHealth((player.getFightHealth()-this.strength));
		}
	}

	public void defend(boolean isDefencefailed,Player player) {
		if(isDefencefailed){
			this.setHealth(health-player.getStrength());
		}
	}

	@Override
	public Long getHealth() {
		return health;
	}

	@Override
	public Long getStrength() {
		return strength;
	}

	@Override
	public Long getExpPoints() {
		return expPoints;
	}
	
	public void printStats(){
		System.out.println("Enemy:"+name+" Stats-> Health:"+health +" Strength:"+strength+" Experience Points To Win:"+expPoints);
	}


}
