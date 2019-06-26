package com.game.application.game.builder.player;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.game.application.builder.CharacterBuilder;
import com.game.application.builder.SimpleCharacterBuilder;
import com.game.application.builder.player.PlayerBuilder;
import com.game.application.builder.player.SageBuilder;
import com.game.application.builder.player.WarriorBuilder;
import com.game.application.model.Player;
import com.game.application.model.PlayerCharacter;

public class PlayerBuilderTest {
	
	PlayerCharacter pCharacter ;
	
	@Before
	public void beforeEach(){
		CharacterBuilder characterBuilder = new SimpleCharacterBuilder();
	characterBuilder.createNewCharacter();
	characterBuilder.setCharacterName("Senthil");
	characterBuilder.setCharacterTitle("Lord");
	characterBuilder.setCharacterGender("Male");
	pCharacter = characterBuilder.buildCharacter();
		
	}
	
	@Test
	public void playerBuilderWarriorTest(){
		
		PlayerBuilder builder =  new WarriorBuilder();
		builder.createNewPlayer(pCharacter);
		Player warriorPlayer=builder.getPlayer();
		
		Assertions.assertThat(warriorPlayer.getExperience()).isEqualTo(5L);
		Assertions.assertThat(warriorPlayer.getHealth()).isEqualTo(100L);
		Assertions.assertThat(warriorPlayer.getStrength()).isEqualTo(100L);
		
		
	}
	
	@Test
	public void playerBuilderSageTest(){
		
		PlayerBuilder builder =  new SageBuilder();
		builder.createNewPlayer(pCharacter);
		Player warriorPlayer=builder.getPlayer();
		
		Assertions.assertThat(warriorPlayer.getExperience()).isEqualTo(10L);
		Assertions.assertThat(warriorPlayer.getHealth()).isEqualTo(150L);
		Assertions.assertThat(warriorPlayer.getStrength()).isEqualTo(50L);
		
		
	}

}
