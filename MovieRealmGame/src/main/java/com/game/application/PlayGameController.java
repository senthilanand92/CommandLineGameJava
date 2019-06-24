package com.game.application;

import com.game.application.model.Player;

public class PlayGameController extends GameController{
	
	public void playGame(Player player) {
		clearConsole();
		printStats(player);
		if(player.getCharacter().getGender().equalsIgnoreCase("male"))
		System.out.println("O Great Sire " +player.getCharacter().getTitle()+ " "+ player.getCharacter().getName()+ " what shall we do now");
		else
		 System.out.println("O Great MiLady " +player.getCharacter().getTitle()+ " "+ player.getCharacter().getName()+ " what shall we do now");
		
		for(String option:inGameOptions){
			System.out.println(option);
		}
		System.out.println("Enter the first word of the command:");
		
		String choice = input.next();
		
		if(choice.equalsIgnoreCase("save")){
			this.saveGame(player);
			playGame(player);
		}
		if(choice.equalsIgnoreCase("explore")){
			this.saveGame(player);
			playGame(player);
		}
		
	}
	

}
