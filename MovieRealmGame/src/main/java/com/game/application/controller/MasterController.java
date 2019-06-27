package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public class MasterController implements CommonController,GameConstants{
	
	
	public void showLaunchOptions(){
		// Show all the options 
		IOUtility utility=IOUtility.getInstance();
		String choice="";
		utility.printOutput("Welcome To the Movie Realm where you/n"
				+ "can explore the marvel and DC universe.\n Fight the evil villian loki and gain exp points"
				+"Save your progress and load it anytime");
		boolean isRetry=false;
		do {
			isRetry=false;
			try{
				utility.printSeperator();
		utility.printOutput("What do you want to do? ");
		utility.printCommands(startOptions);
			utility.printOutput("Enter the command letter of the command:");
			choice=utility.getStringInput();
			// New Game
			if(choice.equalsIgnoreCase("N")){
				Player player=newGame();
				playGame(player);
			}
			// Load game
			else if(choice.equalsIgnoreCase("L")){
				Player player=loadSavedGame();
				if(player!=null)
				playGame(player);
				else{
					isRetry=true;
				}
			}
			
			// Exit game
			else if(choice.equalsIgnoreCase("E")){
				utility.printOutput("Thanks for Playing");
				isRetry=false;
			}
			else{
				utility.printOutput("Please enter a valid input.");
				isRetry=true;
			}
			}
			catch(Exception e){
				utility.printOutput(e.getMessage());
				isRetry=true;
			}
		}while(isRetry);
	}
	public void playGame(Player player) {
		PlayGameController playGameController=(PlayGameController) controllerResolver.getController("play");
		playGameController.playGame(player,this);
	}
	
	public void exploreMap(Player player){
		ExploreController exploreController=(ExploreController) controllerResolver.getController("explore");
		exploreController.exploreMap(player);
	}
	
	public void fight(Player player){
		FightController fightController= (FightController) controllerResolver.getController("fight");
		fightController.fight(player);
	}
	
	public Player newGame(){
		GameController gameController= (GameController) controllerResolver.getController("gameState");
		return gameController.newGame();
	}
	
	public Player loadSavedGame(){
		GameController gameController= (GameController) controllerResolver.getController("gameState");
		return gameController.loadSavedGame();
	}
	
	public void saveGame(Player player){
		GameController gameController= (GameController) controllerResolver.getController("gameState");
		 gameController.saveGame(player);
	}


}
