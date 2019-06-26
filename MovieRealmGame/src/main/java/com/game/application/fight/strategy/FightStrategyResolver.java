package com.game.application.fight.strategy;

import java.util.Random;


public class FightStrategyResolver {
	
static FightStrategyResolver instance;
	
	private FightStrategyResolver(){
		
	}
	public static FightStrategyResolver getInstance(){
		
		if(instance == null){
			instance= new FightStrategyResolver();
		}
		return instance;
	}
	
	public FightStrategy getStrategy(String strategy){
		
		if(strategy.equalsIgnoreCase("randomno")){
			Random  random = new Random();
			return new RandomNoFightStrategy(random);
		}
		else{
			//Default Strategy
			Random  random = new Random();
			return new RandomNoFightStrategy(random);
		}
		
		
		
	}

}
