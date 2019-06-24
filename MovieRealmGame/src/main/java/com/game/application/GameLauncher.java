package com.game.application;


import com.game.application.model.Player;

public class GameLauncher  implements GameConstants {
	
	PlayGameController controller = new PlayGameController();
	
	public static void main(String args[]){
		
		GameLauncher gl = new GameLauncher();
		gl.startGame();
		
	}
	
	private void startGame(){
		String choice="";
		System.out.println("Welcome To the Movie Realm");
		
			System.out.println("What do you want to do?/n");
			for(String option:startOptions){
				System.out.println(option);
			}
			System.out.println("Enter the first word of the command:");
			choice=input.next();
			
			if(choice.equalsIgnoreCase("new")){
				Player player=controller.newGame();
				controller.playGame(player);
			}
			else if(choice.equalsIgnoreCase("load")){
				Player player=controller.loadSavedGame();
				if(player!=null)
				controller.playGame(player);
			}
			else if(choice == "Exit"){
				System.out.println("Thanks for Playing");
			}
			if(choice.equalsIgnoreCase(startOptions.get(0))){
			}
			
	}
	
	
	
	private void loadGame(){
		
	}
	
	

}
