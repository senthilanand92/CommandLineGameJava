package com.game.application.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GameStateMemento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9125278374871928895L;

	private Player player;
	
	private String timeStamp;
	
	private String saveGameName;
	
	public GameStateMemento(Player player, String saveGameName) {
		super();
		this.player = player;
		this.saveGameName = saveGameName;
		this.timeStamp= LocalDateTime.now().toString();
	}


	public Player getPlayer() {
		return player;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public String getSaveGameName() {
		return saveGameName;
	}


	@Override
	public String toString() {
		return "GameStateMemento [player=" + player + ", timeStamp=" + timeStamp + ", saveGameName=" + saveGameName
				+ "]";
	}
	
	
	

}
