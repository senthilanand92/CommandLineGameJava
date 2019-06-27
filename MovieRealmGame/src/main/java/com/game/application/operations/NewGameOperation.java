package com.game.application.operations;

import com.game.application.builder.CharacterBuilder;
import com.game.application.builder.SimpleCharacterBuilder;
import com.game.application.builder.player.PlayerBuilder;
import com.game.application.builder.player.SageBuilder;
import com.game.application.builder.player.WarriorBuilder;
import com.game.application.constants.GameConstants;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;

public class NewGameOperation implements GameControllerOperation, GameConstants{

	public Player execute(Player player,Object parameter) {
		
		// Create a new Character
		CharacterBuilder characterBuilder = new SimpleCharacterBuilder();
		
		String userInput="";
		characterBuilder.createNewCharacter();
		boolean isRetry=false;
		PlayerBuilder builder =null;
		do{
			isRetry=false;
			try{
		utility.printOutput(newCharacterQuestions.get(0));
		userInput = utility.getStringInput();	
		characterBuilder.setCharacterName(userInput);
		
		utility.printOutput(newCharacterQuestions.get(1));
		userInput = utility.getStringInput();	
		characterBuilder.setCharacterTitle(userInput);
		
		utility.printOutput(newCharacterQuestions.get(2));
		userInput = utility.getStringInput();	
		characterBuilder.setCharacterGender(userInput);
		PlayerCharacter pCharacter = characterBuilder.buildCharacter();
		
		utility.printOutput(newCharacterQuestions.get(3));
		userInput = utility.getStringInput();	
		// Warrior chosen
		if(userInput.equalsIgnoreCase("W")){
			builder = new WarriorBuilder();
		}
		// Sage chosen
		else if(userInput.equalsIgnoreCase("S")){
			builder = new SageBuilder();
		}
		else{
			// Default warrior chosen
			builder = new WarriorBuilder();
		}
		// Create a new player
		builder.createNewPlayer(pCharacter);
			} catch(Exception ex){
				// Some validation stuff
				isRetry=true;
				if(null != ex.getMessage())
				{
				utility.printOutput(ex.getMessage());
				}
				else{
					utility.printOutput("That not a valid input,Lets try again");
				}
					
			}
		}while(isRetry);
		Player playerLocal=builder.getPlayer();
		return playerLocal;
	}


}
