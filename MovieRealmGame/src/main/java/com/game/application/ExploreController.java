package com.game.application;

import com.game.application.map.MapElements;
import com.game.application.map.MarvelUniverse;
import com.game.application.model.Player;

public class ExploreController implements GameConstants,MapElements {
	
	public static void main(String args[]){
		ExploreController c = new ExploreController();
		c.exploreMap(null);
	}
	
	public void exploreMap(Player player){
		
		MarvelUniverse marvelUniverseMap = new MarvelUniverse();
		String output="";
		boolean isNotExited= true;
		while(isNotExited){
			marvelUniverseMap.printMap();
			System.out.println(output);
			System.out.println("Where to move:");
			String choice=input.next();
			if(choice.equalsIgnoreCase("north"))
			{
				output=marvelUniverseMap.moveNorth();
				}
			else if(choice.equalsIgnoreCase("south"))
			{
				output=marvelUniverseMap.moveSouth();
				}
			else if(choice.equalsIgnoreCase("east"))
			{
				output=marvelUniverseMap.moveEast();
				}
			else if(choice.equalsIgnoreCase("west"))
			{
				output=marvelUniverseMap.moveWest();
				}
			if(output.equalsIgnoreCase(EXIT)){
				System.out.println("Exited");
				System.out.println("Say bye to leave");
				input.next();
				isNotExited=false;
			}
		}
		
		
	}

}
