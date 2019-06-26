package com.game.application.fight.strategy;

import java.util.Random;

import com.game.application.GameConstants;
import com.game.application.model.Enemy;
import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public class RandomNoFightStrategy implements FightStrategy,GameConstants {

	Random  random = new Random();
	IOUtility utility=IOUtility.getInstance();

	public String attack(Player player, Enemy enemy,Object parameter) {
		String output="Attack was defended by enemy";
		boolean isRetry=false;
		do{
			isRetry=false;
		try{
			utility.printOutput("You are attacking with a strength of "+player.getStrength());
			utility.printOutput("Choose a no between 1 to 6.. :");
		Integer userInp=utility.getIntegerInput();
		Integer randomNo=random.nextInt(7);
		System.out.println("The no was:"+randomNo);
		boolean isAttackSuccessful=false;
		if(randomNo.equals(userInp)){
			isAttackSuccessful=true;
			output="Attack was Successfull";
		}
		enemy.defend(isAttackSuccessful, player);
		
		if(enemy.getHealth() <=0){
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

	public String defend(Player player, Enemy enemy,Object parameter) {
		String output="You were Attacked by enemy and lose"+enemy.getStrength()+" health";
		boolean isRetry=false;
		do{
			isRetry=false;
		try{
		utility.printOutput("You are defending an attack by enemy whose strength is "+enemy.getStrength());
		utility.printOutput("Choose a no between 1 to 6.. :");
		Integer userInp=utility.getIntegerInput();
		Integer randomNo=random.nextInt(7);
		boolean isDefenceSuccessful=false;
		utility.printOutput("The no was:"+randomNo);
		if(randomNo.equals(userInp)){
			isDefenceSuccessful=true;
			output="Defence was Successfull";
		}
		enemy.attack(isDefenceSuccessful, player);
		if(player.getFightHealth() <=0){
			output="Loss";
		}
		}catch(Exception ex){
			isRetry=true;
			utility.printOutput(ex.getMessage());
		}
		}while(isRetry);
		return output;
	}

}
