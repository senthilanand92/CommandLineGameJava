package com.game.application.builder;

public class SimpleCharacterBuilder  extends CharacterBuilder{

	@Override
	public void setCharacterName(String name) {
		pCharacter.setName(name);
	}

	@Override
	public void setCharacterTitle(String title) {
		pCharacter.setTitle(title);
	}

	@Override
	public void setCharacterGender(String gender) {
		pCharacter.setGender(gender);
		
	}

}
