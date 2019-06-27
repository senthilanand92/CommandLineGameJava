# CommandLineGameJava - Movie Realm
Welcome to the movie realm command line game where you can 
<Br/>1)Create your own character
<Br/>2)Explore the worlds of Marven and DC universe tracked in a map.
<Br/>3)Fight the evil villian Loki
<Br/>4) Save your progress and Load it up whenever you get the superhero craze.

# Instructions - How To Run
<Br/>Using Executable
<Br/>1) Windows - Run the Executable/runGame.bat
<Br/>2) Linux - Run the Executable/runGame.sh

<Br/>Using JAR
<Br/>1) Get the Jar from the target folder in GIT or build using the maven.
<Br/>2) Run using Java -jar (jarname)

<Br/>Thats All.

# Instructions - How To play
1) Main menu has three options
	<Br/> 1.1 New Game
	<Br/> 1.2 Load Game
	<Br/> 1.3 Exit Game
	
	<Br/> 1.1- New Game - Create a new character
		<Br/> - Enter your name : (Thor)
		<Br/> - Enter your title : (King)
		<Br/> - Enter your gender : (male)
		<Br/> -"Are you a Brave Warrior or a Wise Sage(Warrior[W]/Sage[S])" : (W / S)
		
		Stats 
		Warrior- health - 100 , Strength-100 , Experience - 5
		Sage - health - 150 , Strength-50 , Experience - 10
		
	 After creation a new check point is automatically created and you enter the Movie Realm.
		
	<Br/> 1.2 Load Game
		<Br/> - A List of previously saved games are displayed with player name , time stamp and serial no
		<Br/> - Choose the serial no of the game you want to load.
		<Br/> - You enter the Movie Realm with that check point.
	<Br/> 1.3 Exit Game
		<Br/> - You have exited the game safely
		
2) Play Game has 4 Options
	<Br/> 1.1 Explore
	<Br/> 1.2 Fight
	<Br/> 1.3 Save
	<Br/> 1.4 Back
	
	<Br/> 1.1 Explore
		<Br/> - You will be taken to the Marvel Universe first(Fan Alert).
		<Br/> - The map is painted in the screen with four walls and some mysterious letters.
		<Br/> - You can move North,South,East or West using the commands (N / S / E /W)
		<Br/> - Move to the letters to see the what they are , beware you shall not pass the walls.
		<Br/> - All Commands ar single letters
		<Br/> - Additional commands -Can Switch to DC Universe (sw) anytime and sw again will switch back to Marvel Universe  <Br/> with the same postition you were.
		<Br/> - Moving to E will exit you or type Ex as displayed on the screen.
		<Br/> - Have fun exploring.
	
	<Br/> 1.2 Fight	
		<Br/> - A great man once said , You can have a great skill but still chance matters on the particular day for your <Br/> skill to shine through
		<Br/> - You get to duel with Loki, (Attack / Defend)
		<Br/> - Fight Rules - Your strength is your damage, so if you get a successful Attack the enemy will lose as much <Br/> health as your strength same appliec vice versa in Defend.
		<Br/> - Successful attack or defend is in the hands of Fate, You have to choose a random no between 0 to 6(both inclusive) 
		<Br/> and the fate will also choose a number if you match then your attack or defense is successful.
		<Br/> - Pray you get thro, else I have coded a cheat code to beat the fate. Use input 8055(Spells Boss, isn't it cool)<Br/>  to always get a successful attack or defense.
		<Br/> -If you win you get the exp points for that enemy else you are sent back but you come back and try again anytime.
	<Br/> 1.3 Save
		<Br/> - You can save your progress- Use the S command to enter savemode
		<Br/> - Enter your save game Name and the game will saved. You can load this checkpoint from the load game command in the main menu
		<Br/> - Back
		<Br/> - Return you to the Main menu

<Br/> Happy Playing . Raise an issue if you run into an error or spotted a bug . 

# Instructions - Coders/Contributors

<Br/> Junits are fully built for all the functionality- It is at a healthy 80%
<Br/> Code Comments are added whereever possbile to be self explanatory.

Common Design Patterns used - Builder, Controller, Command, Strategy , Memento

<Br/> Dependencies used,
<Br/> 1) powermock-module-junit4 - Junit- Static method mocking.
<Br/> 2) powermock-api-mockito -Junit -  Using mockito for mock object handling.
<Br/> 3) asertJ - Junit - Using for assertion in Junits


Couple of feature I didn't have time to Code but can be Done
<Br/> 1) Add more enemy
<Br/> 2) Move all the message to propertie file with placeholders
<Br/> 3) Sanitize more input validation.
<Br/> 4) Add a new save kind of Save strategy - To connect to DB or use JSON
<Br/> 5) Add a new  Fight Strategy- Let the Skill triumph over the gods of fate.
<Br/> 6) Create more Maps
<Br/> 7) Add Items in the map to intract with
<Br/> 8) Add an optional parameter -to pass in that gives the save filename and location.
		
		