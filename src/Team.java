
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Team {
	private String teamName;
    private String teamLogo;
    private ArrayList<Player> players;
    private static List<Player> allplayers;
    private int wins;
    private int losses;
    private static Team opteam;
    private static Team team;

    // Constructor
    public Team() {
        players = new ArrayList<>();
        wins = 0;
        losses = 0;
    }
    
    public static void setAllplayers(List<Player> allplayerss) {
    	allplayers = allplayerss;
	}

    
    public static void displayTeams() {
        displayTeam(team);
        displayTeam(opteam);
    }
    
    
    public static Team getOpteam() {
		return opteam;
	}


	public static Team getTeam() {
		return team;
	}


	// Updated method to choose a player by name
    private static Player choosePlayerByName(String playerName, List<Player> availablePlayers) {
        for (Player player : availablePlayers) {
            if (player.getPlayerName().equalsIgnoreCase(playerName)) {
                return player;
            }
        }
        return null; // Player not found
    }

    private void addPlayer(Player player) {
    	players.add(player);
	}

	// Method to calculate the team's score
    public int calculateTeamScore() {
        int teamScore = 0;
        for (Player player : players) {
            teamScore += player.calculatePlayerScore();
        }
        return teamScore;
    }

 // Method to increment wins
    public void incrementWins() {
        wins++;
    }

    // Method to increment losses
    public void incrementLosses() {
        losses++;
    }

    // Getter method for wins
    public int getWins() {
        return wins;
    }

    // Getter method for losses
    public int getLosses() {
        return losses;
    }

    // Getter method for team name
    public String getTeamName() {
        return teamName;
    }

    // Getter method for team logo
    public String getTeamLogo() {
        return teamLogo;
    }
    
    
    private static void displayTeam(Team team) {
        System.out.println("Team Name: " + team.getTeamName());
        System.out.println("Team Logo: " + team.getTeamLogo());
        System.out.println("Players:");
        for (Player player : team.getPlayers()) {
        	System.out.print(player.getPosition());
            System.out.println("- " + player.getPlayerName());
        }
        System.out.println("Wins: " + team.getWins());
        System.out.println("Losses: " + team.getLosses());
    }

	private Player[] getPlayers() {
        return players.toArray(new Player[0]);
	}
	
	public static void CreateTeams() {
		team = new Team();
		opteam = new Team();
	}

	public static Player addCplayers(String text) {
        List<Player> players = getCPlayerList();
        // Add the chosen player to the team
        team.addPlayer(choosePlayerByName(text, allplayers));
        allplayers.remove(choosePlayerByName(text, allplayers));
        

        // Opponent team randomly chooses a player
        int randomIndex = new Random().nextInt(players.size());
        opteam.addPlayer(players.get(randomIndex));
        allplayers.remove(players.get(randomIndex));
		return players.get(randomIndex);
		
	}

	public static Player addPGplayers(String text) {
        List<Player> players = getPGPlayerList();
        // Add the chosen player to the team
        team.addPlayer(choosePlayerByName(text, allplayers));
        allplayers.remove(choosePlayerByName(text, allplayers));
        

        // Opponent team randomly chooses a player
        int randomIndex = new Random().nextInt(players.size());
        opteam.addPlayer(players.get(randomIndex));
        allplayers.remove(players.get(randomIndex));
		return players.get(randomIndex);
		
	}

	public static Player addPFplayers(String text) {
        List<Player> players = getPFPlayerList();
        // Add the chosen player to the team
        team.addPlayer(choosePlayerByName(text, allplayers));
        allplayers.remove(choosePlayerByName(text, allplayers));
  

        // Opponent team randomly chooses a player
        int randomIndex = new Random().nextInt(players.size());
        opteam.addPlayer(players.get(randomIndex));
        allplayers.remove(players.get(randomIndex));
		return players.get(randomIndex);
		
	}

	public static Player addSGplayers(String text) {
        List<Player> players = getSGPlayerList();
        // Add the chosen player to the team
        team.addPlayer(choosePlayerByName(text, allplayers));
        allplayers.remove(choosePlayerByName(text, allplayers));
        

        // Opponent team randomly chooses a player
        int randomIndex = new Random().nextInt(players.size());
        opteam.addPlayer(players.get(randomIndex));
        allplayers.remove(players.get(randomIndex));
		return players.get(randomIndex);
		
	}

	public static Player addSFplayers(String text) {
        List<Player> players = getSFPlayerList();
        // Add the chosen player to the team
        team.addPlayer(choosePlayerByName(text, allplayers));
        allplayers.remove(choosePlayerByName(text, allplayers));
        

        // Opponent team randomly chooses a player
        int randomIndex = new Random().nextInt(players.size());
        opteam.addPlayer(players.get(randomIndex));
        allplayers.remove(players.get(randomIndex));
		return players.get(randomIndex);
		
	}

	public static List<Player> getPGPlayerList() {
		Stream<Player> playersPosition = allplayers.stream().filter(player -> player.getPosition().equals("PG"));
        List<Player> players = playersPosition.collect(Collectors.toList());
    	return players;
	}

	public static List<Player> getPFPlayerList() {
		Stream<Player> playersPosition = allplayers.stream().filter(player -> player.getPosition().equals("PF"));
        List<Player> players = playersPosition.collect(Collectors.toList());
    	return players;
	}

	public static List<Player> getSGPlayerList() {
		Stream<Player> playersPosition = allplayers.stream().filter(player -> player.getPosition().equals("SG"));
        List<Player> players = playersPosition.collect(Collectors.toList());
    	return players;
	}

	public static List<Player> getSFPlayerList() {
		Stream<Player> playersPosition = allplayers.stream().filter(player -> player.getPosition().equals("SF"));
        List<Player> players = playersPosition.collect(Collectors.toList());
    	return players;
	}
	
	public static List<Player> getCPlayerList(){
    	Stream<Player> playersPosition = allplayers.stream().filter(player -> player.getPosition().equals("C"));
        List<Player> players = playersPosition.collect(Collectors.toList());
    	return players;
    }

	}
