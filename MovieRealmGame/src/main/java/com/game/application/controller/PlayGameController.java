package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.model.Player;

public class PlayGameController implements CommonController,GameConstants{

	public void playGame(Player player, MasterController mController) {
		boolean isRetry = false;
		do {
			isRetry = false;
			try {
				utility.printSeperator();
				player.printStats(false);
				if (player.getCharacter().getGender().equalsIgnoreCase("male"))
					utility.printOutput("O Great Sire " + player.getCharacter().getTitle() + " "
							+ player.getCharacter().getName() + " what shall we do now");
				else
					utility.printOutput("O Great MiLady " + player.getCharacter().getTitle() + " "
							+ player.getCharacter().getName() + " what shall we do now");

				utility.printCommands(inGameOptions);
				utility.printOutput("Enter the command:");

				String choice = utility.getStringInput();

				if (choice.equalsIgnoreCase("S")) {
					mController.saveGame(player);		
					isRetry=true;
				} else if (choice.equalsIgnoreCase("E")) {
					mController.exploreMap(player);
					isRetry=true;
				} else if (choice.equalsIgnoreCase("B")) {
					mController.showLaunchOptions();
					isRetry=false;
				} else if (choice.equalsIgnoreCase("F")) {
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
