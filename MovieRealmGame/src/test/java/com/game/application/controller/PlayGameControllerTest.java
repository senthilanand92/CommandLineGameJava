package com.game.application.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtility.class)
public class PlayGameControllerTest {
	
	PlayGameController instance;
	Player gPlayer;
	@Before
	public void setup(){
		instance = new PlayGameController();
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 pCharacter.setGender("Male");
		 pCharacter.setTitle("Lord");
		 gPlayer = new Player(pCharacter);
	}
	
	//Ideally test by mockito times called using Mockito verify
	@Test
	public void testController() throws InvalidInputException{
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		 
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(utility.getStringInput()).thenReturn("S","E","F","B");
		
		MasterController mController = mock(MasterController.class);
		instance.playGame(gPlayer, mController);
		
		
	}

}
