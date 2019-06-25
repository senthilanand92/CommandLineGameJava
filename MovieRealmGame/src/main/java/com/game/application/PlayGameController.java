package com.game.application;

import com.game.application.model.Player;

public class PlayGameController extends GameController{
	
	public void playGame(Player player,MasterController mController) {
		player.printStats(false);
		if(player.getCharacter().getGender().equalsIgnoreCase("male"))
		System.out.println("O Great Sire " +player.getCharacter().getTitle()+ " "+ player.getCharacter().getName()+ " what shall we do now");
		else
		 System.out.println("O Great MiLady " +player.getCharacter().getTitle()+ " "+ player.getCharacter().getName()+ " what shall we do now");
		
		printCommands();
		System.out.println("Enter the command:");
		
		String choice = input.next();
		
		if(choice.equalsIgnoreCase("save")){
			this.saveGame(player);
			mController.playGame(player);
		}
		else if(choice.equalsIgnoreCase("explore")){
			mController.exploreMap(player);
		}
		else if(choice.equalsIgnoreCase("back")){
			mController.showLaunchOptions();
		}
		else if(choice.equalsIgnoreCase("fight")){
			mController.fight(player);
		}
		
	}
	
	private void printCommands(){
		System.out.println("Use one of these commands :");
		for(String Option:inGameOptions){
			System.out.print(" ["+Option+"] ");
		}
		System.out.println("]");
		
	}
	

}
