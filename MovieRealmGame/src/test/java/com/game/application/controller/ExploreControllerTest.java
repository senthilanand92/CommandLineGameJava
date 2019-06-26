package com.game.application.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.map.DCUniverse;
import com.game.application.map.MarvelUniverse;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;
import com.game.application.utility.IOUtility;



@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtility.class)
public class ExploreControllerTest {
	
	ExploreController controller;
	 Player player ;
	
	@Before
	public void init(){
		controller= new ExploreController();
		 PlayerCharacter pCharacter=new PlayerCharacter();
		 pCharacter.setName("Senthil");
		 player= new Player(pCharacter);
		
		
	}
	
	@Test
	public void testExplore() throws InvalidInputException{
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		 when(IOUtility.getInstance()).thenReturn(utility);
		 boolean exceptionOccured=false;
		 when(utility.getStringInput()).thenReturn("N","S","E","w","Sw","Ex","bye");
		 try{
			 controller.exploreMap(player);
		 }
		 catch(Throwable th){
			 exceptionOccured=true;
		 }
		
		 
		 Assertions.assertThat(exceptionOccured).isEqualTo(false);
		
	}
	
	@Test
	public void testMapDC(){
		
		DCUniverse map = new DCUniverse();
		int initialX= map.getCurrentPositionX();
		int initialY= map.getCurrentPositiony();
		
		map.moveNorth();
		map.moveWest();
		map.moveSouth();
		map.moveEast();
		
		Assertions.assertThat(initialX).isEqualTo(map.getCurrentPositionX());
		Assertions.assertThat(initialY).isEqualTo(map.getCurrentPositiony());
	}
	
	@Test
	public void testMapMarvel(){
		
		MarvelUniverse map = new MarvelUniverse();
		int initialX= map.getCurrentPositionX();
		int initialY= map.getCurrentPositiony();
		
		map.moveNorth();
		map.moveWest();
		map.moveSouth();
		map.moveEast();
		
		Assertions.assertThat(initialX).isEqualTo(map.getCurrentPositionX());
		Assertions.assertThat(initialY).isEqualTo(map.getCurrentPositiony());
	}
	
	
	

}
