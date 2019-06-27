package com.game.application.operations;

import java.util.List;

import com.game.application.constants.GameConstants;
import com.game.application.exceptions.InvalidInputException;
import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.save.Strategy.SaveGameStrategy;
import com.game.application.save.Strategy.SaveGameStrategyResolver;

public class LoadGamesOperation implements GameControllerOperation,GameConstants{
	
	
	
	public Player execute(Player player, Object parameter) {
		
		// Choose the strategy to load Game, can be replaced to use DB or JSOn based load
		SaveGameStrategy saveGameStrategy = saveGameStrategyResolver.getStrategy("Simple");
		Player chosenLoadgame=null;
		
		// retrive the memento list
		List<GameStateMemento> mementoList=saveGameStrategy.loadSavedGamesList();
		// if none found then exit
		if(mementoList == null || mementoList.isEmpty()){
			utility.printOutput("No saved Games found");
			utility.getAnyInput();
		}
		// print list and as user to choose
		else{
			boolean isRetry=false;
			do{
			try{
				isRetry=false;
				utility.printSeperator();
			int i=1;
			utility.printOutput("SNo:Timestamp:Playername:Savegamename");
			for(GameStateMemento memento:mementoList){
				
				utility.printOutput(i+":  "+memento.getTimeStamp()+":"+memento.getPlayer().getCharacter().getName()+
						":"+memento.getSaveGameName());
				i++;
			}
			
			utility.printOutput("Choose the Sno to load(Input should be a number):");
			int choice = utility.getIntegerInput();
			// Only chose a s no that is available
			if(choice >mementoList.size() || choice<=0 ){
				throw new InvalidInputException("Please choose a value between 1 to "+mementoList.size() );
			}
			utility.printSeperator();
			// Load the game and return game
			chosenLoadgame=mementoList.get(choice-1).getPlayer();
			} catch(Exception ex){
				isRetry=true;
				utility.printOutput(ex.getMessage());
			}
			}while(isRetry);
			
		}
		
		return chosenLoadgame;
		
		
		
	}

}
