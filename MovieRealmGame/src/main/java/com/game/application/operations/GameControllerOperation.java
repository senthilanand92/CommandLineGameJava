package com.game.application.operations;

import com.game.application.model.Player;
import com.game.application.save.Strategy.SaveGameStrategyResolver;
import com.game.application.utility.IOUtility;

@FunctionalInterface
public interface GameControllerOperation {
	IOUtility utility=IOUtility.getInstance();
	SaveGameStrategyResolver saveGameStrategyResolver= SaveGameStrategyResolver.getInstance();
    Player execute(Player player,Object parameter);
}
