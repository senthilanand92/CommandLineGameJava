package com.game.application.save.Strategy;

public class SaveGameStrategyResolver {
	
	static private SaveGameStrategyResolver instance;
	
	private SaveGameStrategyResolver(){
		
	}
	public static SaveGameStrategyResolver getInstance(){
		
		if(instance == null){
			instance= new SaveGameStrategyResolver();
		}
		return instance;
	}
	
	public SaveGameStrategy getStrategy(String strategy){
		// Choose the  strategy to save the game 
		if(strategy.equalsIgnoreCase("Simple")){
			return new SimpleSaveGameStrategy();
		}
		else{
			return new SimpleSaveGameStrategy();
		}
		
		
		
	}

}
