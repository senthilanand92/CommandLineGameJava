package com.game.application.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.operation.executor.GameOperationExecutor;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameOperationExecutor.class,IOUtility.class})
public class MasterControllerTest {

	MasterController controller;
	
	ExploreController eController;
	
	FightController fController;
	
	PlayGameController pController;
	
	IOUtility utility;
	
	GameOperationExecutor exec;
	
	@Before
	public void init(){
		controller = new MasterController();
		eController= mock(ExploreController.class);
		fController = mock(FightController.class);
		pController= mock(PlayGameController.class);
		
		controller.setExploreController(eController);
		controller.setFightController(fController);
		controller.setPlayerGameController(pController);
		
		 mockStatic(IOUtility.class);
		 mockStatic(GameOperationExecutor.class);
		 utility=mock(IOUtility.class);
		 exec=mock(GameOperationExecutor.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(GameOperationExecutor.getInstance()).thenReturn(exec);
	}
	
	@Test
	public void testMasterController() throws InvalidInputException{
		
		 when(utility.getStringInput()).thenReturn("N","L","E");
		controller.showLaunchOptions();
		
		
	}
}
