package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.fight.strategy.FightStrategy;
import com.game.application.model.Enemy;
import com.game.application.model.Loki;
import com.game.application.model.Player;

public class FightController implements GameConstants,CommonController {
	
	public void fight(Player player){
	
	player.resetHealth();
	utility.printOutput("Welcome to Fight Mode , Win the battles to gain experience points.\n"
			+ "May fates be Kinder to you");
	
	FightStrategy fightStrategy= fightStrategyResolver.getStrategy("randomno");
	
	String result;
	Enemy enemy =getEnemy();
	do{
		utility.printSeperator();
		player.printStats(true);
		enemy.printStats();
		result=fightStrategy.attack(player, enemy, null);
		utility.printOutput("Result:"+result);
		if(result.equalsIgnoreCase("won")){
			handleWin(player,enemy);
			break;
		}
		utility.getAnyInput();
		result=fightStrategy.defend(player, enemy, null);
		utility.printOutput("Result:"+result);
		utility.getAnyInput();
		if(result.equalsIgnoreCase("Loss")){
			handleLoss(player,enemy);
			break;
		}
		utility.printSeperator();
	}while(true);
	}
	
	
	private void handleWin(Player player,Enemy enemy){
		utility.printOutput("You have won the fight"+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Awesome. Adding exp points:"+player.getExperience());
		player.addExperiencePoints(enemy.getExpPoints());
		utility.printOutput("Exited");
		utility.getAnyInput();
		
	}
	
	private void handleLoss(Player player,Enemy enemy){
		utility.printOutput("You have lost the fight "+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Better luck next time.");
		utility.printOutput("Exited");
		utility.getAnyInput();
	}
	
	//Add a factory for enemy
	private Enemy getEnemy(){
		
		Enemy enemy= new Loki();
		
		return enemy;
		
	}

}
