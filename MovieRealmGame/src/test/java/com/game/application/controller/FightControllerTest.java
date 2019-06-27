package com.game.application.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.fight.strategy.FightStrategyResolver;
import com.game.application.fight.strategy.RandomNoFightStrategy;
import com.game.application.model.Enemy;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FightStrategyResolver.class,IOUtility.class})
public class FightControllerTest {
	
	FightController fController;
	Player gPlayer;
	
	@Before
	public void setup(){
		fController= new FightController();
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 gPlayer = new Player(pCharacter);
		 gPlayer.setExperience(15L);
		
	}

	@Test
	public void handleWinTest(){
		 mockStatic(IOUtility.class);
		 mockStatic(FightStrategyResolver.class);
		 IOUtility utility=mock(IOUtility.class);
		 FightStrategyResolver resolver=mock(FightStrategyResolver.class);
		 RandomNoFightStrategy rNoFight=mock(RandomNoFightStrategy.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(FightStrategyResolver.getInstance()).thenReturn(resolver);
		 when(resolver.getStrategy(Mockito.anyString())).thenReturn(rNoFight);
		 when(rNoFight.attack(Mockito.any(Player.class), Mockito.any(Enemy.class), Mockito.any())).thenReturn("Won");
		fController.fight(gPlayer);
		Assertions.assertThat(gPlayer.getExperience()).isEqualTo(20L);
	}
}
