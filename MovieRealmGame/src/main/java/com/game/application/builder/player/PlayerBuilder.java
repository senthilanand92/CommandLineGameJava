package com.game.application.builder.player;

import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;

//WIll be more useful if the code is growing to complex characters as then construtors with mutiple fields
//will be more complex to handle
public abstract class PlayerBuilder {
	protected Player player;
	
	public Player getPlayer(){
		return player;
	}
	
	public void createNewPlayer(PlayerCharacter pCharacter) {
		player = new Player(pCharacter);
		setInitialHealth();
		setInitialStrength();
		setInitialExperience();
    }
	 public abstract void setInitialHealth();
	 public abstract void setInitialStrength();
	 public abstract void setInitialExperience();
}