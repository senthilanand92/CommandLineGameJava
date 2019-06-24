package com.game.application.controller.operation;

import com.game.application.GameConstants;
import com.game.application.builder.CharacterBuilder;
import com.game.application.builder.SimpleCharacterBuilder;
import com.game.application.builder.player.PlayerBuilder;
import com.game.application.builder.player.SageBuilder;
import com.game.application.builder.player.WarriorBuilder;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;

public class NewGameOperation implements GameControllerOperation, GameConstants{

	public Player execute(Player player,Object parameter) {
		CharacterBuilder characterBuilder = new SimpleCharacterBuilder();
		
		String userInput="";
		characterBuilder.createNewCharacter();
		
		System.out.println(newCharacterQuestions.get(0));
		userInput = input.next();	
		characterBuilder.setCharacterName(userInput);
		
		System.out.println(newCharacterQuestions.get(1));
		userInput = input.next();	
		characterBuilder.setCharacterTitle(userInput);
		
		System.out.println(newCharacterQuestions.get(2));
		userInput = input.next();	
		characterBuilder.setCharacterGender(userInput);
		PlayerCharacter pCharacter = characterBuilder.getCharacter();
		
		System.out.println(newCharacterQuestions.get(3));
		userInput = input.next();	
		PlayerBuilder builder =null;
		
		if(userInput.equalsIgnoreCase("warrior")){
			builder = new WarriorBuilder();
		}
		else if(userInput.equalsIgnoreCase("sage")){
			builder = new SageBuilder();
		}
		
		
		builder.createNewPlayer(pCharacter);
		builder.setInitialHealth();
		builder.setInitialStrength();
		builder.setInitialExperience();
		Player playerLocal=builder.getPlayer();
		return playerLocal;
	}


}
