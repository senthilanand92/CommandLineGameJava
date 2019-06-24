package com.game.application;

import java.util.List;

import com.game.application.controller.GameOperationExecutor;
import com.game.application.controller.operation.GameControllerOperation;
import com.game.application.controller.operation.LoadGamesOperation;
import com.game.application.controller.operation.NewGameOperation;
import com.game.application.controller.operation.SaveGameOperation;
import com.game.application.model.Player;

public class GameController implements GameConstants {

	private GameOperationExecutor executor = new GameOperationExecutor();
	GameLauncher launcher = new GameLauncher(); 

	public void printStats(Player player){
		System.out.println("Stats-> Health:"+player.getHealth() +" Strength:"+player.getStrength()+" Experience Points:"+player.getExperience());
	}

	public void saveGame(Player player) {
		GameControllerOperation saveGameoperation = new SaveGameOperation();
		System.out.println("Please enter a save Game name:");
		String saveGameName=input.next();
		executor.executeOperation(saveGameoperation, player, saveGameName);
		System.out.println("Game successfully saved");
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
		
		Player chosenLoadGame=loadGameoperation.execute(null, null);
		
		return chosenLoadGame;
	}
	
	
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}

}
