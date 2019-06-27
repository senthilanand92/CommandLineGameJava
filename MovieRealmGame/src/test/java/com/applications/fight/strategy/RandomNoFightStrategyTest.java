package com.applications.fight.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.fight.strategy.FightStrategyResolver;
import com.game.application.fight.strategy.RandomNoFightStrategy;
import com.game.application.model.Enemy;
import com.game.application.model.Loki;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.utility.IOUtility;
@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtility.class)
public class RandomNoFightStrategyTest {
	
	RandomNoFightStrategy instance;
	Player gPlayer;
	 Enemy enemy;
	
	@Before
	public void init(){
		FightStrategyResolver resolver = FightStrategyResolver.getInstance();
		instance = (RandomNoFightStrategy) resolver.getStrategy("randomno");
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 pCharacter.setTitle("lord");
		
		 gPlayer = new Player(pCharacter);
		 gPlayer.setStrength(25L);
		 gPlayer.setHealth(25L);
		 
		 
		 enemy= new Loki();
		 enemy.setHealth(25L);
			
	}
	
	@Test
	public void testRandomNoFightWin() throws InvalidInputException{
		gPlayer.resetHealth();
		 Random randomMock= mock(Random.class);
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		instance.setRandom(randomMock);
		 when(IOUtility.getInstance()).thenReturn(utility);
		when(utility.getIntegerInput()).thenReturn(1);
		when(randomMock.nextInt(Mockito.anyInt())).thenReturn(1);
		String result=instance.attack(gPlayer, enemy, null);
		Assertions.assertThat(result).isEqualTo("Won");
		
		
	}
	
	@Test
	public void testRandomNoFightDefend() throws InvalidInputException{
		gPlayer.resetHealth();
		 Random randomMock= mock(Random.class);
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		instance.setRandom(randomMock);
		 when(IOUtility.getInstance()).thenReturn(utility);
		when(utility.getIntegerInput()).thenReturn(1);
		when(randomMock.nextInt(Mockito.anyInt())).thenReturn(1);
		String result=instance.defend(gPlayer, enemy, null);
		Assertions.assertThat(result).isEqualTo("Defence was Successfull");
	}

}
