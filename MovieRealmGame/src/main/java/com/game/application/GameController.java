package com.game.application;



import com.game.application.controller.GameOperationExecutor;
import com.game.application.controller.operation.GameControllerOperation;
import com.game.application.controller.operation.LoadGamesOperation;
import com.game.application.controller.operation.NewGameOperation;
import com.game.application.controller.operation.SaveGameOperation;
import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public abstract class GameController implements GameConstants {

	private GameOperationExecutor executor = new GameOperationExecutor();
	GameLauncher launcher = new GameLauncher(); 
	IOUtility utility = IOUtility.getInstance();


	public void saveGame(Player player) {
		
		GameControllerOperation saveGameoperation = new SaveGameOperation();
		try{
			utility.printSeperator();
			utility.printOutput("Please enter a save Game name:");
		String saveGameName=utility.getStringInput();
		executor.executeOperation(saveGameoperation, player, saveGameName);
		utility.printOutput("Game successfully saved");
		utility.printSeperator();
		}
		catch(Exception e){
			saveGame(player);
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
