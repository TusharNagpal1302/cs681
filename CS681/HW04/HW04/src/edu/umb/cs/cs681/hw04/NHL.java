package edu.umb.cs.cs681.hw04;

import java.util.ArrayList;


public class NHL {

	private String teamName;
	private int matchesPlayed;
	private int won;
	private int points;
	
	public NHL(String teamName, int matchesPlayed, int won, int points) {
		this.teamName = teamName;
		this.matchesPlayed = matchesPlayed;
		this.won = won;
		this.points = points;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getWon() {
		return won;
	}

	public int getPoints() {
		return points;
	}

	public static void main(String args[]) {
		ArrayList<NHL> Table=new ArrayList<>();
		
		NHL BOS = new NHL("BOS",70,44,100);
		NHL STL = new NHL("STL",71,42,94);
		NHL COL = new NHL("COL",70,42,92);
		NHL TBL = new NHL("TBL",70,43,91);
		NHL WSH = new NHL("WSH",69,41,90);
		NHL PHI = new NHL("PHI",69,41,89);
		Table.add(BOS);
		Table.add(STL);
		Table.add(COL);
		Table.add(TBL);
		Table.add(TBL);
		Table.add(WSH);
		Table.add(PHI);
		
	
		Integer maxPlayed = Table.stream().map((NHL nhl)-> nhl.getMatchesPlayed()).reduce(0, (result, matchesPlayed)->{
			if(result==0) 
				return matchesPlayed;
			else if(matchesPlayed > result) 
				return matchesPlayed; 
			return result;});

	
		Integer maxWon = Table.stream().map((NHL nhl) -> nhl.getWon()).reduce(0,(result, won)->{
			if(result==0)
				return won;
			else if(won > result)
				return won;
			return result;});

		
		Integer count = Table.stream().map((NHL nhl) -> nhl.getWon()).reduce(0, (result, carPrice)->{
			return ++result;});
		
		
		Integer maxPoints = Table.stream().map((NHL nhl) -> nhl.getPoints()).reduce(0,(result, points)->{
			if(result==0)
				return points;
			else if(points > result)
				return points;
			return result;});
		
		System.out.println("Standings for season 2019-2020" );
		System.out.println("Total Teams: " + count );
		System.out.println("Max match played by any team: " + maxPlayed);
		System.out.println("Max no. of wins: " + maxWon);
		System.out.println("Max points: " + maxPoints);
		
	}
}
