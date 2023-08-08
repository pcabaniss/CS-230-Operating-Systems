package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity  {

	private static List<Team> teams = new ArrayList<Team>();
	

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		
		super(id, name);
		
	}
	
	// Method for adding a team with checks

	public Team addTeam(String name) {
		
		// Create local instance of team 
		Team team = null;
		
		// Check for existing team with name
		for (int i = 0; i < teams.size(); i++) {
			
			// If a match is found, return that team.
			if (name == teams.get(i).getName()) {
				
				System.out.println("A team with that name already exists: ");
				System.out.println(teams.get(i).getName());
				team = teams.get(i);
			}
		}
		
		// If no match is found, create a new team and add him to list
		if (team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}
		
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id = " + getId() + ", name = " + getName() + "]";
	}

}
