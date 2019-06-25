package com.game.application;

import com.game.application.map.DCUniverse;
import com.game.application.map.MapElements;
import com.game.application.map.MarvelUniverse;
import com.game.application.map.NavigableGameMap;
import com.game.application.model.Player;

public class ExploreController implements GameConstants,MapElements {
	
	
	public void exploreMap(Player player,MasterController mController ){
		
		String output="";
		boolean isNotExited= true;
		NavigableGameMap marvelUniverseMap=  new MarvelUniverse();
		NavigableGameMap DCUniverseMap=  new DCUniverse();
		
		NavigableGameMap currentMap= marvelUniverseMap;
		while(isNotExited){
			currentMap.printMap();
			printCommands();
			System.out.println(output);
			System.out.println("Where to move:");
			String choice=input.next();
			if(choice.equalsIgnoreCase("north"))
			{
				output=currentMap.moveNorth();
				}
			else if(choice.equalsIgnoreCase("south"))
			{
				output=currentMap.moveSouth();
				}
			else if(choice.equalsIgnoreCase("east"))
			{
				output=currentMap.moveEast();
				}
			else if(choice.equalsIgnoreCase("west"))
			{
				output=currentMap.moveWest();
				}
			else if(choice.equalsIgnoreCase("exit"))
			{
				System.out.println("Exited");
				System.out.println("Say bye to leave");
				input.next();
				isNotExited=false;
				}
			else if(choice.equalsIgnoreCase("switch"))
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
			if(output.equalsIgnoreCase(EXIT)){
				System.out.println("Exited");
				System.out.println("Say bye to leave");
				input.next();
				isNotExited=false;
			}
		}
		
		mController.playGame(player);
	}
	
	private void printCommands(){
		System.out.println("Use one of these commands :");
		for(String Option:exploreOptions){
			System.out.print(" ["+Option+"] ");
		}
		System.out.println("]");
		
	}

}
