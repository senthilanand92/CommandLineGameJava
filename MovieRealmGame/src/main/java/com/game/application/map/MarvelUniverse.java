package com.game.application.map;

public class MarvelUniverse implements NavigableGameMap,MapElements {
	static{
		String A="Avengers Headquarters";
		String I="Iron Mans Party";
		String H="Hulks Restaurant";
		String C="Captain America's Gym";
	}
	
	private Integer currentPositionX=7;
	private Integer currentPositionY=10;
	String prevPlace=PATH;
	
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
	
	
	private String getMessage(String position,String move){
		 if(position.equalsIgnoreCase("A"))
			return "You have reached Avengers Headquarters";
		else if(position.equalsIgnoreCase("I"))
			return "You have reached Iron Mans Party";
		else if(position.equalsIgnoreCase("H"))
			return "You have reached Hulks Restaurant";
		else if(position.equalsIgnoreCase("C"))
			return "You have reached Captain America's Gym";
		else if(position.equalsIgnoreCase(EXIT))
			return EXIT;
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
		System.out.println(marvelMap.length);
		System.out.println(marvelMap[0].length);
		System.out.println(marvelMap[10][7]);
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
