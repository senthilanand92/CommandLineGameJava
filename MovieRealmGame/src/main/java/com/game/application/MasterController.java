package com.game.application;

import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public class MasterController extends GameController{
	
	PlayGameController playerGameController = new PlayGameController();
	
	ExploreController exploreController= new ExploreController();
	
	FightController fightController = new FightController();
	
	public void playGame(Player player) {
		playerGameController.playGame(player,this);
	}
	
	public void exploreMap(Player player){
		exploreController.exploreMap(player,this);
	}
	
	public void fight(Player player){
		fightController.fight(player, this);
	}
	
	public void showLaunchOptions(){
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
		utility.printOutput("What do you want to do? /n");
		utility.printCommands(startOptions);
			utility.printOutput("Enter the command letter of the command:");
			choice=utility.getStringInput();
			
			if(choice.equalsIgnoreCase("N")){
				Player player=newGame();
				playGame(player);
			}
			else if(choice.equalsIgnoreCase("L")){
				Player player=loadSavedGame();
				if(player!=null)
				playGame(player);
			}
			else if(choice.equalsIgnoreCase("E")){
				utility.printOutput("Thanks for Playing");
				isRetry=false;
			}
			}
			catch(Exception e){
				utility.printOutput(e.getMessage());
				isRetry=true;
			}
		}while(isRetry);
	}
	

}
