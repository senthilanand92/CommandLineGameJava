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
		boolean isInvalid=false;
		do{
		utility.printOutput(newCharacterQuestions.get(2));
		userInput = utility.getStringInput();
		isInvalid=true;
		if(isInvalid && ! (userInput.equalsIgnoreCase("male")
				|| userInput.equalsIgnoreCase("female")))
			utility.printOutput("Please enter either male or female");
		}
		while(! (userInput.equalsIgnoreCase("male")
				|| userInput.equalsIgnoreCase("female")));
		
		characterBuilder.setCharacterGender(userInput);
		PlayerCharacter pCharacter = characterBuilder.buildCharacter();
		
		isInvalid=false;
		do{
		utility.printOutput(newCharacterQuestions.get(3));
		
		if(isInvalid && ! (userInput.equalsIgnoreCase("w")
				|| userInput.equalsIgnoreCase("s")))
		{
			utility.printOutput("Please enter either w or s");
		}
		userInput = utility.getStringInput();
		isInvalid=true;
			}while(! (userInput.equalsIgnoreCase("w")
				|| userInput.equalsIgnoreCase("s")));
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
					utility.printOutput("Thats not a valid input,Lets try again");
				}
					
			}
		}while(isRetry);
		Player playerLocal=builder.getPlayer();
		return playerLocal;
	}


}
