package com.game.application.controller;

import com.game.application.fight.strategy.FightStrategyResolver;
import com.game.application.operation.executor.GameOperationExecutor;
import com.game.application.utility.IOUtility;

public interface CommonController {
	IOUtility utility = IOUtility.getInstance();
	FightStrategyResolver fightStrategyResolver = FightStrategyResolver.getInstance();
	GameOperationExecutor executor= GameOperationExecutor.getInstance();
}
