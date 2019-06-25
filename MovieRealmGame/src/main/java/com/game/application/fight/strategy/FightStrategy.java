package com.game.application.fight.strategy;

import com.game.application.model.Enemy;
import com.game.application.model.Player;

public interface FightStrategy {
	
	public String attack(Player player,Enemy enemy,Object parameter);
	public String defend(Player player,Enemy enemy,Object parameter);

}
