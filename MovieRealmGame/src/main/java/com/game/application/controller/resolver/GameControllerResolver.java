package com.game.application.controller.resolver;

import com.game.application.controller.ExploreController;
import com.game.application.controller.FightController;
import com.game.application.controller.GameController;
import com.game.application.controller.PlayGameController;
import com.game.application.save.Strategy.SimpleSaveGameStrategy;

public class GameControllerResolver {
	
	private static GameControllerResolver instance;
	
	public static GameControllerResolver getInstance(){
		if(instance == null){
			instance = new GameControllerResolver();
		}
		return instance;
	}
	
	public Object getController(String controllerName){
		// Choose the  strategy to save the game 
		if(controllerName.equalsIgnoreCase("gameState")){
			return new GameController();
		}
		else if(controllerName.equalsIgnoreCase("play")){
			return new PlayGameController();
		}
		else if(controllerName.equalsIgnoreCase("explore")){
			return new ExploreController();
		}
		else if(controllerName.equalsIgnoreCase("fight")){
			return new FightController();
		}
		
		else{
			return new SimpleSaveGameStrategy();
		}
		
		
		
	}	
	
	

}
