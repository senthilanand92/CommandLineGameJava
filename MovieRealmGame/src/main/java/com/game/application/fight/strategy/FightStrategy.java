package com.game.application.fight.strategy;

import com.game.application.model.Enemy;
import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

public interface FightStrategy {
	IOUtility utility=IOUtility.getInstance();
	public String attack(Player player,Enemy enemy,Object parameter);
	public String defend(Player player,Enemy enemy,Object parameter);

}
