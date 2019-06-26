package com.game.application.controller.operation;

import com.game.application.model.Player;
import com.game.application.utility.IOUtility;

@FunctionalInterface
public interface GameControllerOperation {
	IOUtility utility=IOUtility.getInstance();
    Player execute(Player player,Object parameter);
}
