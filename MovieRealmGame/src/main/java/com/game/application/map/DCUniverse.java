package com.game.application.map;

import java.util.HashMap;
import java.util.Map;

public class DCUniverse implements NavigableGameMap,MapElements {
	
	private static Map<String,String> specialPlacesMap= new HashMap<String,String>();
	static{
		specialPlacesMap.put("B", "You have reached BatCave");
		specialPlacesMap.put("S", "You have found Shazam's lair");
		specialPlacesMap.put("J", "You have reached Justice League Headquarters");
		specialPlacesMap.put("C", "You have reached Wonder Woman's Island");
	}
	
	private Integer currentPositionX=7;
	private Integer currentPositionY=10;
	String prevPlace=PATH;
	
	public  String[][] marvelMap= {
			{SIDEWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,SIDEWALL},
			{SIDEWALL,PATH,"B",PATH,PATH,PATH,PATH,"W",SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,"S",PATH,PATH,PATH,PATH,"J",SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,SIDEWALL},
			{SIDEWALL,PATH,PATH,PATH,PATH,PATH,PATH,Player,EXIT},
			{SIDEWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,LATERALWALL,SIDEWALL}	
	};
	
	
	private String getMessage(String position,String move){
		 if(position.equalsIgnoreCase(EXIT))
			 return EXIT;
		else if(specialPlacesMap.containsKey(position))
			return specialPlacesMap.get(position);
		return  "Moved "+move;
	}

	public String moveNorth() {
		if((marvelMap[currentPositionY-1][currentPositionX])==LATERALWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionY=currentPositionY-1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"North");
	}

	public String moveSouth() {
		if((marvelMap[currentPositionY+1][currentPositionX])==LATERALWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionY=currentPositionY+1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"South");
	}

	public String moveEast() {
		if((marvelMap[currentPositionY][currentPositionX+1])==SIDEWALL )
			return "Cannot move as wall is there";
		marvelMap[currentPositionY][currentPositionX]=prevPlace;
		currentPositionX=currentPositionX+1;
		prevPlace=marvelMap[currentPositionY][currentPositionX];
		marvelMap[currentPositionY][currentPositionX]=Player;
		
		return getMessage(prevPlace,"East");
	}

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
	
	public  void printMap() 
    { 
        // Loop through all rows 
        for (int i = 0; i < marvelMap.length; i++) {
  
            // Loop through all elements of current row 
            for (int j = 0; j < marvelMap[i].length; j++) 
            {
                System.out.print(marvelMap[i][j] + " ");
            }
        
        System.out.println();
        }
    } 
	

}
