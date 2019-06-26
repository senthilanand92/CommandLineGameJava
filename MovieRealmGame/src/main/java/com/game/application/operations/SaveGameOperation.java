package com.game.application.operations;

import com.game.application.constants.GameConstants;
import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.save.Strategy.SaveGameStrategy;
import com.game.application.save.Strategy.SaveGameStrategyResolver;
import com.game.application.save.Strategy.SimpleSaveGameStrategy;

public class SaveGameOperation implements GameControllerOperation,GameConstants{
	

	public Player execute(Player player,Object parameter) {
		
		SaveGameStrategy saveGameStrategy = saveGameStrategyResolver.getStrategy("Simple");
		GameStateMemento memento=null;
		if(null == parameter){
			memento = new GameStateMemento(player,newGameSaveName);
		}
		else{
		    memento = new GameStateMemento(player,(String) parameter);
		}
		utility.printOutput("Saving game.."+memento);
		saveGameStrategy.saveGame(memento);
		
		return player;
	}

}
