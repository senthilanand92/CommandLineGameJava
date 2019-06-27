# CommandLineGameJava - Movie Real.m
Welcome to the movie realm command line game where you can 
1)Create your own character
2)Explore the worlds of Marven and DC universe tracked in a map.
3)Fight the evil villian Loki
4) Save your progress and Load it up whenever you get the superhero craze.

# Instructions - How To Run
1) Get the Jar from the target folder in GIT or build using the maven.
2) Run using Java -jar (jarname)

Thats All.

# Instructions - How To play
1) Main menu has three options
	<Br/> 1.1 New Game
	<Br/> 1.2 Load Game
	<Br/> 1.3 Exit Game
	
	1.1- New Game - Create a new character
		- Enter your name : (Thor)
		- Enter your title : (King)
		- Enter your gender : (male)
		-"Are you a Brave Warrior or a Wise Sage(Warrior[W]/Sage[S])" : (W / S)
		
		Stats 
		Warrior- health - 100 , Strength-100 , Experience - 5
		Sage - health - 150 , Strength-50 , Experience - 10
		
		After creation a new check point is automatically created and you enter the Movie Realm.
		
	1.2 Load Game
		- A List of previously saved games are displayed with player name , time stamp and serial no
		- Choose the serial no of the game you want to load.
		- You enter the Movie Realm with that check point.
	1.3 Exit Game
		- You have exited the game safely
		
2) Play Game has 4 Options
	<Br/> 1.1 Explore
	<Br/> 1.2 Fight
	<Br/> 1.3 Save
	<Br/> 1.4 Back
	
	1.1 Explore
		- You will be taken to the Marvel Universe first(Fan Alert).
		- The map is painted in the screen with four walls and some mysterious letters.
		- You can move North,South,East or West using the commands (N / S / E /W)
		- Move to the letters to see the what they are , beware you shall not pass the walls.
		- All Commands ar single letters
		- Additional commands -Can Switch to DC Universe (sw) anytime and sw again will switch back to Marvel Universe with the same postition you were.
		- Moving to E will exit you or type Ex as displayed on the screen.
		- Have fun exploring.
	
	1.2 Fight	
		- A great man once said , You can have a great skill but still chance matters on the particular day for your skill to shine through
		- You get to duel with Loki, (Attack / Defend)
		- Fight Rules - Your strength is your damage, so if you get a successful Attack the enemy will lose as much health as your strength same appliec vice versa in Defend.
		- Successful attack or defend is in the hands of Fate, You have to choose a random no between 0 to 6(both inclusive) 
		and the fate will also choose a number if you match then your attack or defense is successful.
		- Pray you get thro, else I have coded a cheat code to beat the fate. Use input 8055(Spells Boss, isn't it cool) to always get a successful attack or defense.
		-If you win you get the exp points for that enemy else you are sent back but you come back and try again anytime.
	1.3 Save
		- You can save your progress- Use the S command to enter savemode
		- Enter your save game Name and the game will saved. You can load this checkpoint from the load game command in the main menu
		- Back
		- Return you to the Main menu

Happy Playing . Raise an issue if you run into an error or spotted a bug . 

# Instructions - Coders/Contributors

Junits are fully built for all the functionality- It at a healthy 80%

Dependencies used,
1) powermock-module-junit4 - Junit- Static method mocking.
2) powermock-api-mockito -Junit -  Using mockito for mock object handling.
3) asertJ - Junit - Using for assertion in Junits


Couple of feature I didn't have time to Code but can be Done
1) Add more enemy
2) Move all the message to propertie file with placeholders
3) Sanitize more input validation.
4) Add a new save kind of Save strategy - To connect to DB or use JSON
5) Add a new  Fight Strategy- Let the Skill triumph over the gods of fate.
6) Create more Maps
7) Add Items in the map to intract with
8) Add an optional parameter -to pass in that gives the save filename and location.
		
		