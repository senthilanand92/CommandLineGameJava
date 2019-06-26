package com.game.application.map;

import java.util.HashMap;
import java.util.Map;

public class MarvelUniverse implements NavigableGameMap,MapElements {
	private static Map<String,String> specialPlacesMap= new HashMap<String,String>();
	static{
		// Special places in the map
		specialPlacesMap.put("A", "You have reached Avengers Headquarters");
		specialPlacesMap.put("I", "You have reached Iron Mans Party");
		specialPlacesMap.put("H", "You have reached Hulks Restaurant");
		specialPlacesMap.put("C", "You have reached Captain America's Gym");
	}
	// Player start postition in the map , updated as player moves around
	private Integer currentPositionX=7;
	private Integer currentPositionY=10;
	
	// used to move around the map
	String prevPlace=PATH;
	
	// The map in ascii format
	public  String[][] marvelMap= {
			{SIDEWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,SIDEWALL},
			{SIDEWALL,PATH,"H",PATH,PATH,PATH,PATH,"I",SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,"A",PATH,PATH,PATH,PATH,"C",SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,Player,EXIT},
			{SIDEWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,SIDEWALL}	
	};
	
	// Print message as to what happened, if you hit a wall, moved in direction or visited a special place or just exited
	private String getMessage(String position,String move){
		 if(position.equalsIgnoreCase(EXIT))
			 return EXIT;
		else if(specialPlacesMap.containsKey(position))
			return specialPlacesMap.get(position);
		return  "Moved "+move;
	}

	// Method to move north in map
	public String moveNorth() {
		if((marvelMap[currentPositionY-1][currentPositionX])==LATERALWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionY=currentPositionY-1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"North");
	}
	//Method to move south
	public String moveSouth() {
		if((marvelMap[currentPositionY+1][currentPositionX])==LATERALWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionY=currentPositionY+1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"South");
	}

	// method to move east
	public String moveEast() {
		if((marvelMap[currentPositionY][currentPositionX+1])==SIDEWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionX=currentPositionX+1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"East");
	}

	// method to move west
	public String moveWest() {
		if((marvelMap[currentPositionY][currentPositionX-1])==SIDEWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionX=currentPositionX-1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"West");
	}
	
	
	
	public Integer getCurrentPositionX() {
		return currentPositionX;
	}

	public void setCurrentPositionX(Integer currentPositionX) {
		this.currentPositionX = currentPositionX;
	}

	public Integer getCurrentPositiony() {
		return currentPositionY;
	}

	public void setCurrentPositiony(Integer currentPositiony) {
		this.currentPositionY = currentPositiony;
	}
	
	// Print the entire map
	public  void printMap() 
    { 
        for (int row = 0; row < marvelMap.length; row++) {
  
            for (int col = 0; col < marvelMap[row].length; col++) 
            {
                System.out.print(marvelMap[row][col] + " ");
            }
        // New line seperator
        System.out.println();
        }
    } 
	

}
