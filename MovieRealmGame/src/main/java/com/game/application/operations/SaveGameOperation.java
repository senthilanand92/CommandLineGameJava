package com.game.application.operations;

import com.game.application.constants.GameConstants;
import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.save.Strategy.SaveGameStrategy;

public class SaveGameOperation implements GameControllerOperation,GameConstants{
	

	public Player execute(Player player,Object parameter) {
		// Choose the strategy to save Game, can be replaced to use DB or JSOn based Save
		SaveGameStrategy saveGameStrategy = saveGameStrategyResolver.getStrategy("Simple");
		GameStateMemento memento=null;
		// Put Default name for first auto save on character creation
		if(null == parameter){
			memento = new GameStateMemento(player,newGameSaveName);
		}
		// Put the name given by user in the memento
		else{
		    memento = new GameStateMemento(player,(String) parameter);
		}
		utility.printOutput("Saving game..");
		// Save the game
		saveGameStrategy.saveGame(memento);
		utility.printOutput("Game saved.");
		
		return player;
	}

}
