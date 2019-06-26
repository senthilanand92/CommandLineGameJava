package com.game.application.save.Strategy;

public class SaveGameStrategyResolver {
	
	static SaveGameStrategyResolver instance;
	
	private SaveGameStrategyResolver(){
		
	}
	public static SaveGameStrategyResolver getInstance(){
		
		if(instance == null){
			instance= new SaveGameStrategyResolver();
		}
		return instance;
	}
	
	public SaveGameStrategy getStrategy(String strategy){
		
		if(strategy.equalsIgnoreCase("Simple")){
			return new SimpleSaveGameStrategy();
		}
		else{
			return new SimpleSaveGameStrategy();
		}
		
		
		
	}

}
