package com.game.application;

import com.game.application.constants.GameConstants;
import com.game.application.controller.MasterController;

public class GameLauncher  implements GameConstants {
	static MasterController controller;
	static{
		 controller= new MasterController();
	}
	
	public static void main(String args[]){
		GameLauncher gl = new GameLauncher();
		gl.startGame();
		
	}
	public  void startGame(){
		controller.showLaunchOptions();
	}
	
	
	
}
