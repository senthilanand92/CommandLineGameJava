package com.applications.operations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.util.ArrayList;
import java.util.List;

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
import com.game.application.operations.LoadGamesOperation;
import com.game.application.save.Strategy.SaveGameStrategyResolver;
import com.game.application.save.Strategy.SimpleSaveGameStrategy;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveGameStrategyResolver.class,IOUtility.class})
public class LoadGameOperationTest {
	
	
	LoadGamesOperation instance;
	Player player;
	 
	 @Before
	 public void setup(){
		 instance =new  LoadGamesOperation();
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 player = new Player(pCharacter);
	 }
	 
	 @Test
	 public void loadGameOperationTest() throws InvalidInputException{
		 mockStatic(IOUtility.class);
		 mockStatic(SaveGameStrategyResolver.class);
		 IOUtility utility=mock(IOUtility.class);
		 SaveGameStrategyResolver resolver=mock(SaveGameStrategyResolver.class);
		 SimpleSaveGameStrategy simpleSave=mock(SimpleSaveGameStrategy.class);
		 
		 
		 GameStateMemento state= new GameStateMemento(player,"test");
		 List<GameStateMemento> stateList= new ArrayList<GameStateMemento>(1);
		 stateList.add(state);
		 
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(SaveGameStrategyResolver.getInstance()).thenReturn(resolver);
		 when(resolver.getStrategy(Mockito.anyString())).thenReturn(simpleSave);
		 when(simpleSave.loadSavedGamesList()).thenReturn(stateList);
		 when(utility.getIntegerInput()).thenReturn(1);
		 Player player= instance.execute(null, null);
		 Assertions.assertThat(player.getCharacter().getName()).isEqualTo("Senthil");
		 
	 }
	

}
