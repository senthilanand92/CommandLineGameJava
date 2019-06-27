package com.game.application;

import com.game.application.exceptions.InvalidInputException;
import com.game.application.map.DCUniverse;
import com.game.application.map.MapElements;
import com.game.application.map.MarvelUniverse;
import com.game.application.map.NavigableGameMap;
import com.game.application.model.Player;

public class ExploreController extends GameController implements GameConstants,MapElements {
	
	
	public void exploreMap(Player player,MasterController mController ){
		
		String output="";
		boolean isNotExited= true;
		NavigableGameMap marvelUniverseMap=  new MarvelUniverse();
		NavigableGameMap DCUniverseMap=  new DCUniverse();
		
		NavigableGameMap currentMap= marvelUniverseMap;
		do{
			try{
				utility.printSeperator();
			currentMap.printMap();
			utility.printCommands(exploreOptions);
			utility.printOutput(output);
			utility.printOutput("Where to move:");
			String choice=utility.getStringInput();
			if(choice.equalsIgnoreCase("N"))
			{
				output=currentMap.moveNorth();
				}
			else if(choice.equalsIgnoreCase("S"))
			{
				output=currentMap.moveSouth();
				}
			else if(choice.equalsIgnoreCase("E"))
			{
				output=currentMap.moveEast();
				}
			else if(choice.equalsIgnoreCase("W"))
			{
				output=currentMap.moveWest();
				}
			else if(choice.equalsIgnoreCase("E"))
			{
				utility.printOutput("Exited");
				utility.printOutput("Say bye to leave");
				utility.getAnyInput();
				isNotExited=false;
				}
			else if(choice.equalsIgnoreCase("SW"))
			{
				if(currentMap instanceof MarvelUniverse){
					currentMap=DCUniverseMap;
					output="Map Switched to DC Universe. Exploree!!";
				}
				else if (currentMap instanceof DCUniverse){
					currentMap=marvelUniverseMap;
					output="Map Switched to Marvel Universe. Exploree!!";
				}
				}
			else {
				output="Please enter a valid command";
			}
			if(output.equalsIgnoreCase(EXIT)){
				System.out.println("Exited");
				System.out.println("Say bye to leave");
				utility.getAnyInput();
				isNotExited=false;
			}
			utility.printSeperator();
		}catch(Exception ex){
			utility.printOutput(ex.getMessage());
		}
		}while(isNotExited);
		mController.playGame(player);
	}

}
