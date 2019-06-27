package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.model.Player;


//Just add and create a new strategy and add an entry in the strategy resolver to add more  types
//of Save/Load mechanism
public class PlayGameController implements CommonController,GameConstants{

	public void playGame(Player player, MasterController mController) {
		//Play the Game
		boolean isRetry = false;
		do {
			isRetry = false;
			try {
				utility.printSeperator();
				//Print player health , strength and exp points
				player.printStats(false);
				// Show Message based on gender
				if (player.getCharacter().getGender().equalsIgnoreCase("male"))
					utility.printOutput("O Great Sire " + player.getCharacter().getTitle() + " "
							+ player.getCharacter().getName() + " what shall we do now");
				else
					utility.printOutput("O Great MiLady " + player.getCharacter().getTitle() + " "
							+ player.getCharacter().getName() + " what shall we do now");
				
				utility.printCommands(inGameOptions);
				utility.printOutput("Enter the command:");

				String choice = utility.getStringInput();
				// Save game
				if (choice.equalsIgnoreCase("S")) {
					mController.saveGame(player);		
					isRetry=true;
				}
				// Explore Maps
				else if (choice.equalsIgnoreCase("E")) {
					mController.exploreMap(player);
					isRetry=true;
				}
				// Back to main screen
				else if (choice.equalsIgnoreCase("B")) {
					mController.showLaunchOptions();
					isRetry=false;
				} 
				// Go for a Fight
				else if (choice.equalsIgnoreCase("F")) {
					mController.fight(player);
					isRetry=true;
				}
			} catch (Exception ex) {
				utility.printOutput(ex.getMessage());
				isRetry = true;
			}
		} while (isRetry);

	}

}
