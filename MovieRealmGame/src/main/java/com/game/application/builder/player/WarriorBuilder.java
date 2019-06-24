package com.game.application.builder.player;

public class WarriorBuilder extends PlayerBuilder {
	
	@Override
    public void setInitialHealth() {
    	player.setHealth(100L);
    }
	
	@Override
    public void setInitialStrength() {
    	player.setStrength(100L);
    }

	@Override
	public void setInitialExperience() {
		player.setExperience(5L);
	}
}