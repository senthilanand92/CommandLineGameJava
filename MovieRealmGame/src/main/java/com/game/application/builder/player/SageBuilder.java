package com.game.application.builder.player;

public class SageBuilder extends PlayerBuilder {
	
	@Override
    public void setInitialHealth() {
    	player.setHealth(150L);
    }
    @Override
    public void setInitialStrength() {
    	player.setStrength(50L);
    }

	@Override
	public void setInitialExperience() {
		player.setExperience(10L);		
	}
    
}