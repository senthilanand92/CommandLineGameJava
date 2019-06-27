package com.game.application.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.controller.resolver.GameControllerResolver;
import com.game.application.exceptions.InvalidInputException;
import com.game.application.operation.executor.GameOperationExecutor;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameControllerResolver.class,IOUtility.class})
public class MasterControllerTest {

	MasterController controller;
	
	ExploreController eController;
	
	FightController fController;
	
	PlayGameController pController;
	
	GameController gController;
	
	IOUtility utility;
	
	GameControllerResolver resolver;
	
	@Before
	public void init(){
		controller = new MasterController();
		eController= mock(ExploreController.class);
		fController = mock(FightController.class);
		pController= mock(PlayGameController.class);
		gController = mock(GameController.class);
		
		
		 mockStatic(IOUtility.class);
		 mockStatic(GameControllerResolver.class);
		 utility=mock(IOUtility.class);
		 resolver=mock(GameControllerResolver.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(GameControllerResolver.getInstance()).thenReturn(resolver);
		 
		 when(resolver.getController("gameState")).thenReturn(gController);
		 when(resolver.getController("fight")).thenReturn(fController);
		 when(resolver.getController("explore")).thenReturn(eController);
		 when(resolver.getController("play")).thenReturn(pController);
	}
	
	@Test
	public void testMasterController() throws InvalidInputException{
		
		 when(utility.getStringInput()).thenReturn("N","L","E");
		controller.showLaunchOptions();
		
		
	}
}
