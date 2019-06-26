package com.applications.operations;

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
import com.game.application.model.Player;
import com.game.application.operations.NewGameOperation;
import com.game.application.utility.IOUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IOUtility.class)
public class NewGameOperationTest {
	
	
	 NewGameOperation instance;
	 
	 @Before
	 public void setup(){
		 instance =new  NewGameOperation();
	 }
	 
	 @Test
	 public void newGameOperationTest() throws InvalidInputException{
		 mockStatic(IOUtility.class);
		 IOUtility utility=mock(IOUtility.class);
		 
		 when(IOUtility.getInstance()).thenReturn(utility);
		 when(utility.getStringInput()).thenReturn("Senthil","Lord","Male","w");
		 Player player= instance.execute(null, null);
		 Assertions.assertThat(player.getCharacter().getName()).isEqualTo("Senthil");
		 Assertions.assertThat(player.getCharacter().getTitle()).isEqualTo("Lord");
		 Assertions.assertThat(player.getCharacter().getGender()).isEqualTo("Male");
		 
	 }
	

}
