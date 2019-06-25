package com.game.application;

import com.game.application.model.Player;

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
		String choice="";
		System.out.println("Welcome To the Movie Realm where you/n"
				+ "can explore the marvel and DC universe.\n Fight the evil villian loki and gain exp points"
				+"Save your progress and load it anytime");
		
			System.out.println("What do you want to do?/n");
			for(String option:startOptions){
				System.out.println(option);
			}
			System.out.println("Enter the first word of the command:");
			choice=input.next();
			
			if(choice.equalsIgnoreCase("new")){
				Player player=newGame();
				playGame(player);
			}
			else if(choice.equalsIgnoreCase("load")){
				Player player=loadSavedGame();
				if(player!=null)
				playGame(player);
			}
			else if(choice == "Exit"){
				System.out.println("Thanks for Playing");
			}
	}
	

}
