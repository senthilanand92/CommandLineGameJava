package com.game.application.builder;

import com.game.application.model.PlayerCharacter;


// WIll be more useful if the code is growing to complex characters as then construtors with mutiple fields
// will be more complex to handle
public abstract class CharacterBuilder {
	
	protected PlayerCharacter pCharacter;
	
	String pName;
	String pTitle;
	String pGender;
	
	public void createNewCharacter(){
		this.pCharacter= new PlayerCharacter();
	}
	
	public PlayerCharacter buildCharacter(){
		return pCharacter;
	}
	
	 public abstract void setCharacterName(String name);
	 public abstract void setCharacterTitle(String title);
	 public abstract void setCharacterGender(String gender);

	 
	 
}





