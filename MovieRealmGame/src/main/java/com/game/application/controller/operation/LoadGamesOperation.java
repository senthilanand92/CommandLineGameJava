package com.game.application.controller.operation;

import java.util.List;

import com.game.application.GameConstants;
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
			System.out.println("No saved Games found");
		}
		
		else{
			int i=1;
			System.out.println("SNo:Timestamp:Playername:savegamename");
			for(GameStateMemento memento:mementoList){
				
				System.out.println(i+":  "+memento.getTimeStamp()+":"+memento.getPlayer().getCharacter().getName()+
						":"+memento.getSaveGameName());
			}
			
			System.out.println("Choose the Sno to load:");
			int choice = input.nextInt();
			
			chosenLoadgame=mementoList.get(choice-1).getPlayer();
			
		}
		
		return chosenLoadgame;
		
		
		
	}

}
