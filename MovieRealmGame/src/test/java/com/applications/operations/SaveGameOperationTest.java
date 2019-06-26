package com.applications.operations;

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

import com.game.application.exceptions.InvalidInputException;
import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.operations.SaveGameOperation;
import com.game.application.save.Strategy.SaveGameStrategyResolver;
import com.game.application.save.Strategy.SimpleSaveGameStrategy;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveGameStrategyResolver.class,IOUtility.class})
public class SaveGameOperationTest {
	
	
	SaveGameOperation instance;
	Player gPlayer;
	 
	 @Before
	 public void setup(){
		 instance =new  SaveGameOperation();
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 gPlayer = new Player(pCharacter);
	 }
	 
	 @Test
	 public void loadGameOperationTest() throws InvalidInputException{
		 mockStatic(IOUtility.class);
		 mockStatic(SaveGameStrategyResolver.class);
		 IOUtility utility=mock(IOUtility.class);
		 SaveGameStrategyResolver resolver=mock(SaveGameStrategyResolver.class);
		 SimpleSaveGameStrategy simpleSave=mock(SimpleSaveGameStrategy.class);
		 
		 
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(SaveGameStrategyResolver.getInstance()).thenReturn(resolver);
		 when(resolver.getStrategy(Mockito.anyString())).thenReturn(simpleSave);
		 when(simpleSave.saveGame(Mockito.any(GameStateMemento.class))).thenReturn(true);
		 when(utility.getIntegerInput()).thenReturn(1);
		 Player player= instance.execute(gPlayer, null);
		 Assertions.assertThat(player.getCharacter().getName()).isEqualTo("Senthil");
		 
	 }
	

}
