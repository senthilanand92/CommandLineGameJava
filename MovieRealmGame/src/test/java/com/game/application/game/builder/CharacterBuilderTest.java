package com.game.application.game.builder;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.game.application.builder.CharacterBuilder;
import com.game.application.builder.SimpleCharacterBuilder;
import com.game.application.model.PlayerCharacter;

public class CharacterBuilderTest {
	
	@Test
	public void CharacterBuilderTestSimple(){
		CharacterBuilder characterBuilder = new SimpleCharacterBuilder();
		characterBuilder.createNewCharacter();
		characterBuilder.setCharacterName("Senthil");
		characterBuilder.setCharacterTitle("Lord");
		characterBuilder.setCharacterGender("Male");
		PlayerCharacter pCharacter = characterBuilder.buildCharacter();
		
		Assertions.assertThat(pCharacter.getName()).isEqualTo("Senthil");
		Assertions.assertThat(pCharacter.getTitle()).isEqualTo("Lord");
		Assertions.assertThat(pCharacter.getGender()).isEqualTo("Male");
		
		
	}

}
