package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	private List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		
		super(id, name);
	}

	// Method for adding a player with checks
	
	public Player addPlayer(String name) {
		
		Player player = null;
		
		// Check to see if the player name exists
		
		for (int i = 0; i < players.size(); i++) {
			
			// If a match is found, return that player.
			if (name == players.get(i).getName()) {
				
				System.out.println("A player with that name already exists: ");
				System.out.println(players.get(i).getName());
				player = players.get(i);
			}
		}
		
		// If no match is found, create a new player and add him to list
		if (player == null) {
			
			System.out.println("Player added.");
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
			
		}
		
		return player;
	}
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
