package com.game.application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface GameConstants {
	
	List<String> startOptions = Arrays.asList("New Game(N)","Load Game(L)","Exit(E)");
	List<String> newCharacterQuestions = Arrays.asList("What is your name?","What is your title","What is your Gender?","Are you a Brave Warrior or a Wise Sage(Warrior[W]/Sage[S])");
	List<String> inGameOptions=Arrays.asList("Explore(E)","Fight(F)","Save(S)","Back(B)");
	List<String> exploreOptions=Arrays.asList("North(N)","South(S)","East(E)","West(W)","Exit(E)","Switch(SW)");
	
	String saveFileName="MovieRealm-SavedGames.txt";
	String newGameSaveName="NewGameCheckPoint";
	

}
