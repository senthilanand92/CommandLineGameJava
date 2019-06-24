package com.game.application.controller.operation;

import com.game.application.model.Player;

@FunctionalInterface
public interface GameControllerOperation {
    Player execute(Player player,Object parameter);
}
