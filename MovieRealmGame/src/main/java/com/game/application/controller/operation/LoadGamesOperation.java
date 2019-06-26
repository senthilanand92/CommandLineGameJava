package com.game.application.controller.operation;

import java.util.List;

import com.game.application.GameConstants;
import com.game.application.exceptions.InvalidInputException;
import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.save.Strategy.SaveGameStrategy;
import com.game.application.save.Strategy.SimpleSaveGameStrategy;

public class LoadGamesOperation implements GameControllerOperation,GameConstants{

	public Player execute(Player player, Object parameter) {
		
		SaveGameStrategy saveGameStrategy = new SimpleSaveGameStrategy();
		Player chosenLoadgame=null;
		List<GameStateMemento> mementoList=saveGameStrategy.loadSavedGamesList();
		
		if(mementoList == null || mementoList.isEmpty()){
			utility.printOutput("No saved Games found");
			utility.printOutput("Say Bye to Continue");
			utility.getAnyInput();
		}
		
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
			if(choice >mementoList.size() || choice<=0 ){
				throw new InvalidInputException("Please choose a value between 1 to "+mementoList.size() );
			}
			utility.printSeperator();
			
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
