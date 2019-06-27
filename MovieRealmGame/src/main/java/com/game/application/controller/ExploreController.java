package com.game.application.controller;

import com.game.application.constants.GameConstants;
import com.game.application.map.DCUniverse;
import com.game.application.map.MapElements;
import com.game.application.map.MarvelUniverse;
import com.game.application.map.NavigableGameMap;
import com.game.application.model.Player;

public class ExploreController  implements GameConstants,MapElements,CommonController {
	
	public void exploreMap(Player player ){
		
		String output="";
		boolean isNotExited= true;
		NavigableGameMap marvelUniverseMap=  new MarvelUniverse();
		NavigableGameMap DCUniverseMap=  new DCUniverse();
		
		NavigableGameMap currentMap= marvelUniverseMap;
		do{
			try{
			utility.printSeperator();
			currentMap.printMap();
			printMapLegend();
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
			else if(choice.equalsIgnoreCase("Ex"))
			{
				utility.printOutput("Exited");
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
				utility.printOutput("Exited");
				utility.printOutput("Say bye to leave");
				utility.getAnyInput();
				isNotExited=false;
			}
			utility.printSeperator();
		}catch(Exception ex){
			utility.printOutput(ex.getMessage());
		}
		}while(isNotExited);
	}
	
	void printMapLegend(){
		utility.printOutput("Legend: P-PLayer E-Exit .-Walkable Path E-Exit door \n"
				+ "The letters are interesting places explore them");
		
	}
	

}
