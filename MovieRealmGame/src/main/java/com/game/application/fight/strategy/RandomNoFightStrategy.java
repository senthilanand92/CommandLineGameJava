package com.game.application.fight.strategy;

import java.util.Random;

import com.game.application.GameConstants;
import com.game.application.model.Enemy;
import com.game.application.model.Player;

public class RandomNoFightStrategy implements FightStrategy,GameConstants {

	Random  random = new Random();

	public String attack(Player player, Enemy enemy,Object parameter) {
		String output="Attack was defended by enemy";
		System.out.println("You are attacking with a strength of "+player.getStrength());
		System.out.println("Choose a no between 1 to 6.. :");
		Integer userInp=input.nextInt();
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
		return output;
	}

	public String defend(Player player, Enemy enemy,Object parameter) {
		String output="You were Attacked by enemy and lose"+enemy.getStrength()+" health";
		System.out.println("You are defending an attack by enemy whose strength is "+enemy.getStrength());
		System.out.println("Choose a no between 1 to 6.. :");
		Integer userInp=input.nextInt();
		Integer randomNo=random.nextInt(7);
		boolean isDefenceSuccessful=false;
		System.out.println("The no was:"+randomNo);
		if(randomNo.equals(userInp)){
			isDefenceSuccessful=true;
			output="Defence was Successfull";
		}
		enemy.attack(isDefenceSuccessful, player);
		if(player.getFightHealth() <=0){
			output="Loss";
		}
		return output;
	}

}
