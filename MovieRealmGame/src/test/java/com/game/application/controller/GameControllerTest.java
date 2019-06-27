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

import com.game.application.exceptions.InvalidInputException;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.operation.executor.GameOperationExecutor;
import com.game.application.operations.GameControllerOperation;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameOperationExecutor.class,IOUtility.class})
public class GameControllerTest {
	
	GameController instance;
	IOUtility utility;
	 GameOperationExecutor exec;
	
	
	@Before 
	public void init(){
		
		instance= new GameController();
		 mockStatic(IOUtility.class);
		 mockStatic(GameOperationExecutor.class);
		 utility=mock(IOUtility.class);
		 exec=mock(GameOperationExecutor.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(GameOperationExecutor.getInstance()).thenReturn(exec);
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 Player gPlayer = new Player(pCharacter);
		 
		 when(exec.executeOperation(Mockito.any(GameControllerOperation.class), Mockito.any(Player.class), Mockito.any())).thenReturn(gPlayer);
	}
	
	@Test
	public void callMethodSave() throws InvalidInputException{
		
		 when(utility.getStringInput()).thenReturn("testGame");
		 boolean isEx=false;
		 try{
		 instance.saveGame(null);
		 }
		 catch(Exception ex){
			 isEx=true;
		 }
		 Assertions.assertThat(isEx).isEqualTo(false);
	}
	
	@Test
	public void callMethodNew() throws InvalidInputException{
		
		 
		 boolean isEx=false;
		 Player output=null;
		 try{
			 output = instance.newGame();
		 }
		 catch(Exception ex){
			 isEx=true;
		 }
		 Assertions.assertThat(isEx).isEqualTo(false);
		 Assertions.assertThat(output).isNotNull();
		 Assertions.assertThat(output.getCharacter().getName()).isEqualTo("Senthil");
	}
	@Test
	public void callMethodLoad() throws InvalidInputException{
		 
		
		
		 boolean isEx=false;
		 Player output=null;
		 try{
			 output= instance.loadSavedGame();
		 }
		 catch(Exception ex){
			 isEx=true;
		 }
		 Assertions.assertThat(isEx).isEqualTo(false);
		 Assertions.assertThat(output).isNotNull();
		 Assertions.assertThat(output.getCharacter().getName()).isEqualTo("Senthil");
	}

}
