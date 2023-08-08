package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // Replaced with instance of GameService
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Team Fortress");
		System.out.println(game1);
		Game game2 = service.addGame("Diablo IV");
		System.out.println(game2);
		
		game1.addTeam("Blazers").addPlayer("Johnathan");
		game1.addTeam("Blazers").addPlayer("Johnathan");
	
		
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
