package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.fight.strategy.FightStrategy;
import com.game.application.model.Enemy;
import com.game.application.model.Loki;
import com.game.application.model.Player;


//Just add and create a new strategy and add an entry in the strategy resolver to add more  types
// of fight mechanism
public class FightController implements GameConstants,CommonController {
	
	public void fight(Player player){
	
	player.resetHealth();
	utility.printOutput("Welcome to Fight Mode , Win the battles to gain experience points.\n"
			+ "May fates be Kinder to you");
	
	FightStrategy fightStrategy= fightStrategyResolver.getStrategy("randomno");
	// The player attacks and defends in sequence till either the enemy or the player has no more health
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
	
	// Player has won and exp points gets added
	private void handleWin(Player player,Enemy enemy){
		utility.printOutput("You have won the fight"+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Awesome. You have been awarded "+enemy.getExpPoints()+"  exp points.");
		player.addExperiencePoints(enemy.getExpPoints());
		utility.printOutput("Your new total Exp points:"+player.getExperience());
		utility.printOutput("Exited");
		utility.getAnyInput();
		
	}
	// Player has lost
	private void handleLoss(Player player,Enemy enemy){
		utility.printOutput("You have lost the fight "+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Better luck next time.");
		utility.printOutput("Exited");
		utility.getAnyInput();
	}
	
	//Add a factory for enemy
	private Enemy getEnemy(){
		// Get one enemy as of now coded 
		Enemy enemy= new Loki();
		
		return enemy;
		
	}

}
