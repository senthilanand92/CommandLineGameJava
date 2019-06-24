package com.game.application.controller;

import java.util.List;

import com.game.application.controller.operation.GameControllerOperation;
import com.game.application.model.Player;

public class GameOperationExecutor {
	
	 public Player executeOperation(GameControllerOperation gameOperation,Player player,Object parameter) {
	        return gameOperation.execute(player,parameter);
	    }
	 
	 public Player executeOperations(List<GameControllerOperation> gameOperations,Player player,Object parameter) {
	        for(GameControllerOperation gameoperation:gameOperations){
	        	gameoperation.execute(player,parameter);
	        }
	        return player;
	    }
}
