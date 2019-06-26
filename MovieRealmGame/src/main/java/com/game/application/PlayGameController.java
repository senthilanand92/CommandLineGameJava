package com.game.application;

import com.game.application.model.Player;

public class PlayGameController extends GameController {

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
					this.saveGame(player);
					mController.playGame(player);
				} else if (choice.equalsIgnoreCase("E")) {
					mController.exploreMap(player);
				} else if (choice.equalsIgnoreCase("B")) {
					mController.showLaunchOptions();
				} else if (choice.equalsIgnoreCase("F")) {
					mController.fight(player);
				}
			} catch (Exception ex) {
				utility.printOutput(ex.getMessage());
				isRetry = true;
			}
		} while (isRetry);

	}

}
