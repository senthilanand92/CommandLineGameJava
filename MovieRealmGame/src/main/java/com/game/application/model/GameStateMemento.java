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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((saveGameName == null) ? 0 : saveGameName.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		GameStateMemento other = (GameStateMemento) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (saveGameName == null) {
			if (other.saveGameName != null)
				return false;
		} else if (!saveGameName.equals(other.saveGameName))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}


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
