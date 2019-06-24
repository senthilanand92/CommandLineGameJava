package com.game.application.builder.player;

import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;

public abstract class PlayerBuilder {
	protected Player player;
	
	public Player getPlayer(){
		return player;
	}
	
	public void createNewPlayer(PlayerCharacter pCharacter) {
		player = new Player(pCharacter);
    }
	 public abstract void setInitialHealth();
	 public abstract void setInitialStrength();
	 public abstract void setInitialExperience();
}