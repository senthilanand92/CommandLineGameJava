package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.model.Player;
import com.game.application.operations.GameControllerOperation;
import com.game.application.operations.LoadGamesOperation;
import com.game.application.operations.NewGameOperation;
import com.game.application.operations.SaveGameOperation; 


//Just add and create a new strategy and add an entry in the strategy resolver to add more  types
//of Save/Load mechanism
public  class GameController implements GameConstants,CommonController {


	public void saveGame(Player player) {
		//create a operation for save game
		GameControllerOperation saveGameoperation = new SaveGameOperation();
		try{
			utility.printSeperator();
			utility.printOutput("Please enter a save Game name:");
			// Get a save game name input
		String saveGameName=utility.getStringInput();
		
		// Save the game 
		executor.executeOperation(saveGameoperation, player, saveGameName);
		utility.printOutput("Game successfully saved");
		utility.printSeperator();
		}
		catch(Exception e){
			utility.printOutput(e.getMessage());
		}
	}

	public Player newGame() {

		GameControllerOperation newGameoperation = new NewGameOperation();
		GameControllerOperation saveGameoperation = new SaveGameOperation();
		Player player = executor.executeOperation(newGameoperation, null, null);
		executor.executeOperation(saveGameoperation, player, null);

		return player;
	}
	
	public Player loadSavedGame(){
		
		GameControllerOperation loadGameoperation= new LoadGamesOperation();
		
		Player chosenLoadGame = executor.executeOperation(loadGameoperation, null, null);
		
		return chosenLoadGame;
	}
	
	

}
