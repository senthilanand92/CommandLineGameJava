package com.game.application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface GameConstants {
	
	Scanner input= new Scanner(System.in);
	List<String> startOptions = Arrays.asList("New Game","Load Game","Exit");
	List<String> newCharacterQuestions = Arrays.asList("What is your name?","What is your title","What is your Gender?","Are you a Brave Warrior or a Wise Sage(Warrior/Sage)");
	List<String> inGameOptions=Arrays.asList("Explore","Fight","Save","Back");
	List<String> exploreOptions=Arrays.asList("North","South","East","West","Exit","Switch");
	
	String saveFileName="MovieRealm-SavedGames.txt";
	String newGameSaveName="NewGameCheckPoint";
	

}
