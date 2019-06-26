package com.game.application.fight.strategy;

import java.util.Random;

import com.game.application.constants.GameConstants;
import com.game.application.model.Enemy;
import com.game.application.model.Player;

public class RandomNoFightStrategy implements FightStrategy,GameConstants {

	private Random random;
	
	RandomNoFightStrategy(Random random)
	{
		this.random=random;
	}
	
	// Player tried to attack the enemy 
	public String attack(Player player, Enemy enemy,Object parameter) {
		String output="Attack was defended by enemy";
		boolean isRetry=false;
		do{
			isRetry=false;
		try{
			utility.printOutput("You are attacking with a strength of "+player.getStrength());
			utility.printOutput("Choose a no between 1 to 6.. :");
		Integer userInp=utility.getIntegerInput();
		// Generating a random no
		Integer randomNo=random.nextInt(7);
		utility.printOutput("The no was:"+randomNo);
		boolean isAttackSuccessful=false;
		// Cheat code 100 to beat the game
		if(randomNo.equals(userInp) || userInp.equals(8055) ){
			// If user was success in attack
			isAttackSuccessful=true;
			output="Attack was Successfull";
		}
		enemy.defend(isAttackSuccessful, player);
		
		if(enemy.getHealth() <=0){
			// If user won and the enemy is out of health
			output="Won";
		}
		}
		catch(Exception ex){
			isRetry=true;
			utility.printOutput(ex.getMessage());
		}
		}while(isRetry);
		return output;
	}
	// Player tried to defend an attack from the enemy
	public String defend(Player player, Enemy enemy,Object parameter) {
		String output="You were Attacked by enemy and lose "+enemy.getStrength()+" health";
		boolean isRetry=false;
		do{
			isRetry=false;
		try{
		utility.printOutput("You are defending an attack by enemy whose strength is "+enemy.getStrength());
		utility.printOutput("Choose a no between 0 to 6.. :");
		Integer userInp=utility.getIntegerInput();
		// Generating a random no
		Integer randomNo=random.nextInt(7);
		boolean isDefenceSuccessful=false;
		utility.printOutput("The no was:"+randomNo);
		// Cheat code 100 to beat the game
		if(randomNo.equals(userInp) || userInp.equals(8055)){
			// Player successfully defended the attack
			isDefenceSuccessful=true;
			output="Defence was Successfull";
		}
		enemy.attack(isDefenceSuccessful, player);
		if(player.getFightHealth() <=0){
			// User health is all out and the player is defeated
			output="Loss";
		}
		}catch(Exception ex){
			isRetry=true;
			utility.printOutput(ex.getMessage());
		}
		}while(isRetry);
		return output;
	}
	
	public Random getRandom() {
		return random;
	}


	public void setRandom(Random random) {
		this.random = random;
	}


}
