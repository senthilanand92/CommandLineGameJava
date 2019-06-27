package com.game.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.utility.IOUtility;

public class GameModelsTest {

	Player gplayer1;
	Player gplayer2;
	PlayerCharacter pCharacter1;
	PlayerCharacter pCharacter2;

	GameStateMemento state1;
	GameStateMemento state2;
	Enemy enemy1;
	Enemy enemy2;

	@Before
	public void init() {
		pCharacter1 = new PlayerCharacter();
		pCharacter1.setName("Senthil");
		gplayer1 = new Player(pCharacter1);

		pCharacter2 = new PlayerCharacter();
		pCharacter2.setName("Ram");
		gplayer2 = new Player(pCharacter2);

		state1 = new GameStateMemento(gplayer1, "test1");
		state2 = new GameStateMemento(gplayer2, "test2");

		enemy1 = new Loki();
		enemy2 = new Loki();
		
		
	}

	@Test
	public void testIsSerializable() {
		InvalidInputException exception = new InvalidInputException("test");
		boolean isPlayerSerializable = false;
		boolean isCharSerializable = false;
		boolean isMementoSerializable = false;
		boolean isExSerializable = false;

		if (gplayer1 instanceof Serializable) {
			isPlayerSerializable=true;
			
		}
		if (pCharacter1 instanceof Serializable) {
			isCharSerializable=true;
		}
		if (state1 instanceof Serializable) {
			isMementoSerializable=true;
		}
		
		if(exception instanceof Serializable){
			isExSerializable=true;
		}
		Assertions.assertThat(isPlayerSerializable).isTrue();
		Assertions.assertThat(isCharSerializable).isTrue();
		Assertions.assertThat(isMementoSerializable).isTrue();
		Assertions.assertThat(isExSerializable).isTrue();
		
		Assertions.assertThat(gplayer1.toString()).isNotBlank();
		Assertions.assertThat(pCharacter1.toString()).isNotBlank();
		Assertions.assertThat(state1.toString()).isNotBlank();
	}
	
	
	@Test
	public void collectionReadynessTest(){
		
		Assertions.assertThat(gplayer1.equals(gplayer2)).isFalse();
		Assertions.assertThat(pCharacter1.equals(pCharacter2)).isFalse();
		Assertions.assertThat(state1.equals(state2)).isFalse();
		Assertions.assertThat(enemy1.equals(enemy2)).isTrue();
		
		Assertions.assertThat(gplayer1.hashCode()).isNotEqualTo(gplayer2.hashCode());
		Assertions.assertThat(pCharacter1.hashCode()).isNotEqualTo(pCharacter2.hashCode());
		Assertions.assertThat(state1.hashCode()).isNotEqualTo(state2.hashCode());
		Assertions.assertThat(enemy1.hashCode()).isEqualTo(enemy2.hashCode());
		
	}
	
	@Test
	public void simpleIOUtilityTest(){
		 List<String> Commands= new ArrayList<String>(2);
		 Commands.add("Go north");
		 IOUtility.getInstance().printCommands(Commands);
		 IOUtility.getInstance().printOutput("Testing commands");
	}
	

}
