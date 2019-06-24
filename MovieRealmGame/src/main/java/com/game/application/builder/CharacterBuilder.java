package com.game.application.builder;

import com.game.application.model.PlayerCharacter;

public abstract class CharacterBuilder {
	
	protected PlayerCharacter pCharacter;
	
	String pName;
	String pTitle;
	String pGender;
	
	public void createNewCharacter(){
		this.pCharacter= new PlayerCharacter();
	}
	
	public PlayerCharacter getCharacter(){
		return pCharacter;
	}
	
	 public abstract void setCharacterName(String name);
	 public abstract void setCharacterTitle(String title);
	 public abstract void setCharacterGender(String gender);

	 
	 
}





