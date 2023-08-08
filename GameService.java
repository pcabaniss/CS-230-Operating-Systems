package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author phillip.cabaniss@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	private static GameService service = null; // Added instance of GameService
	
	
	// Add missing pieces to turn this class a singleton 
	private GameService() {}
	
	
	
	// Returns current instance
	public static GameService getInstance() {
		
		// Check if a current instance already exists
		
		if (service == null) {
			
			service = new GameService();
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Iterate over each existing game in array list to check for match.
		// If it matches, return the object from the list.

		// Added a for loop for iteration over entire array
		
		for (int i = 0; i < games.size(); i++) {
			
			if (name == games.get(i).getName()) {
				game = games.get(i);
			}
		}
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same id
		// if found, assign that instance to the local variable
		
		// Added a for loop for iteration over entire array
		
		for (int i = 0; i < games.size(); i++) {
			
			if (id == games.get(i).getId()) {
				game = games.get(i);
			}

		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, assign that instance to the local variable
		
		// Added a for loop for iteration over entire array
		
		for (int i = 0; i < games.size(); i++) {
			if (name == games.get(i).getName()) {
				System.out.println("A game with that name already exists: ");
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	// Returns next player id

	public long getNextPlayerId() {
		
		return nextPlayerId++;
	}
	
	// Returns next team id
		
	public long getNextTeamId() {
		
		return nextTeamId++;
	}
}
