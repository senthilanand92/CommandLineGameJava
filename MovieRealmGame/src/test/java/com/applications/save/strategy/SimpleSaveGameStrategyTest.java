package com.applications.save.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import java.io.File;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.model.GameStateMemento;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.save.Strategy.SaveGameStrategy;
import com.game.application.save.Strategy.SaveGameStrategyResolver;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtility.class)
public class SimpleSaveGameStrategyTest {
	
	SaveGameStrategy instance;
	String testPathFile="src/test/resources/test.txt";
	Player player;
	
	@Before
	 public void setup(){
		SaveGameStrategyResolver resolver = SaveGameStrategyResolver.getInstance();
		 instance = resolver.getStrategy("simple");
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 player = new Player(pCharacter);
	 }
	 
	 @Test
	 public void saveAndLoadTest() {
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(utility.getSaveGameFileName()).thenReturn(testPathFile);
		 GameStateMemento state= new GameStateMemento(player,"test");
		 instance.saveGame(state);
		 List<GameStateMemento> mementoList=instance.loadSavedGamesList();
		 Assertions.assertThat(mementoList.get(0).getPlayer().getCharacter().getName()).isEqualTo("Senthil");
		 
	 }
	 
	 @After
	 public void cleanUp(){
		 File file = new File(testPathFile);
		 file.delete();
	 }
	
	

}
