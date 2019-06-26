package com.game.application.operation.executor;

import java.util.List;

import com.game.application.model.Player;
import com.game.application.operations.GameControllerOperation;

public class GameOperationExecutor {
	
	static GameOperationExecutor instance;
	
	private GameOperationExecutor(){
		
	}
	
	public static GameOperationExecutor getInstance(){
		
		if(instance == null ){
			instance= new GameOperationExecutor();
		}
		return instance;
	}
	
	
	
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
