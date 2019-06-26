package com.game.application.controller;

import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public class MasterController extends GameController{
	//Need to move all controllers to a Singleton Resolver Class
	
	private PlayGameController playerGameController = new PlayGameController();
	
	private ExploreController exploreController= new ExploreController();
	
	private FightController fightController = new FightController();
	

	public void playGame(Player player) {
		playerGameController.playGame(player,this);
	}
	
	public void exploreMap(Player player){
		exploreController.exploreMap(player);
	}
	
	public void fight(Player player){
		fightController.fight(player);
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
				else{
					isRetry=true;
				}
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
	


	public PlayGameController getPlayerGameController() {
		return playerGameController;
	}

	public void setPlayerGameController(PlayGameController playerGameController) {
		this.playerGameController = playerGameController;
	}

	public ExploreController getExploreController() {
		return exploreController;
	}

	public void setExploreController(ExploreController exploreController) {
		this.exploreController = exploreController;
	}

	public FightController getFightController() {
		return fightController;
	}

	public void setFightController(FightController fightController) {
		this.fightController = fightController;
	}
}
