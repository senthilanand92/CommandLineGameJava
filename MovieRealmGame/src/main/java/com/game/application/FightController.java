package com.game.application;

import com.game.application.fight.strategy.FightStrategy;
import com.game.application.fight.strategy.RandomNoFightStrategy;
import com.game.application.model.Enemy;
import com.game.application.model.Loki;
import com.game.application.model.Player;

public class FightController extends GameController implements GameConstants {
	MasterController mController;
	
	public void fight(Player player,MasterController mController){
	
		this.mController= mController;
		player.resetHealth();
		
	System.out.println("Welcome to Fight Mode , Win the battles to gain experience points.\n"
			+ "May fates be Kinder to you");
	
	FightStrategy fightStrategy= new RandomNoFightStrategy();
	
	String result;
	Enemy enemy =getEnemy();
	do{
		clearConsole();
		System.out.println("\n\n");
		player.printStats(true);
		enemy.printStats();
		result=fightStrategy.attack(player, enemy, null);
		System.out.println("Result:"+result);
		if(result.equalsIgnoreCase("won")){
			handleWin(player,enemy);
		}
		result=fightStrategy.defend(player, enemy, null);
		System.out.println("Result:"+result);
		if(result.equalsIgnoreCase("Loss")){
			handleLoss(player,enemy);
		}
	}while(true);
	
	
	}
	
	
	private void handleWin(Player player,Enemy enemy){
		System.out.println("You have won the fight"+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Awesome. Adding exp points:"+player.getExperience());
		player.addExperiencePoints(enemy.getExpPoints());
		System.out.println("Exited");
		System.out.println("Say bye to leave");
		input.next();
		mController.playGame(player);
	}
	
	private void handleLoss(Player player,Enemy enemy){
		System.out.println("You have lost the fight"+ player.getCharacter().getTitle()+" "+ player.getCharacter().getName()
				+".\n Better luck next time.");
		System.out.println("Exited");
		System.out.println("Say bye to leave");
		input.next();
		mController.playGame(player);
	}
	
	private Enemy getEnemy(){
		
		Enemy enemy= new Loki();
		
		return enemy;
		
	}

}
