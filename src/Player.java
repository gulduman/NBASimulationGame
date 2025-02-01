
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Player {
	private String playerName;
    private String position;
    private float points;
    private float totalRebounds;
    private float assists;
    private float blocks;
    private float steals;
    private int age;
    private int games;
    private String team;
    
    // Constructor
    public Player(String playerName, String position, float points, float totalRebounds, float assists, float blocks, float steals, int age, String team, int games) {
        this.playerName = playerName;
        this.position = position;
        this.points = points;
        this.totalRebounds = totalRebounds;
        this.assists = assists;
        this.blocks = blocks;
        this.steals = steals;
        this.age = age;
        this.team = team;
        this.games = games;
    }
    
	// Method to calculate player score
    public int calculatePlayerScore() {
        int pointScore = calculateScoreForStat(points, 5);
        int reboundScore = calculateScoreForStat(totalRebounds, 5);
        int assistScore = calculateScoreForStat(assists, 5);
        int blockScore = calculateScoreForStat(blocks, 5);
        int stealScore = calculateScoreForStat(steals, 5);

        return pointScore + reboundScore + assistScore + blockScore + stealScore;
    }

    // Method to calculate score for a specific stat
    private int calculateScoreForStat(float points2, int range) {
        Random random = new Random();
        int randomValue = random.nextInt(range * 2 + 1) - range;
        int weightedScore = (int) (randomValue * 0.2); // Assuming weight is 0.2 for all stats
        return Math.max(weightedScore, 0); 
    }

    // Method to read players from CSV file
    public static ArrayList<Player> readPlayersFromCSV(String filePath) {
        ArrayList<Player> players = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
        	String line;
        	while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
               
                for(int i =0; i< data.length; i++) {
                	String[] ply = data[i].split(";");
                	 String[] positions = ply[2].split("-");
                     
                     for (String position : positions) {
                         Player player = null;
                         switch (position) {
                             case "PG":
                                 player = new PointGuard(ply[1], Float.parseFloat(ply[29]), Float.parseFloat(ply[23]), Float.parseFloat(ply[24]), Float.parseFloat(ply[26]), Float.parseFloat(ply[25]), Integer.parseInt(ply[3]), ply[4], Integer.parseInt(ply[5]));
                                 break;
                             case "SF":
                                 player = new SmallForward(ply[1], Float.parseFloat(ply[29]), Float.parseFloat(ply[23]), Float.parseFloat(ply[24]), Float.parseFloat(ply[26]), Float.parseFloat(ply[25]), Integer.parseInt(ply[3]), ply[4], Integer.parseInt(ply[5]));
                                 break;
                             case "PF":
                                 player = new PowerForward(ply[1], Float.parseFloat(ply[29]), Float.parseFloat(ply[23]), Float.parseFloat(ply[24]), Float.parseFloat(ply[26]), Float.parseFloat(ply[25]), Integer.parseInt(ply[3]), ply[4], Integer.parseInt(ply[5]));
                                 break;
                             case "C":
                                 player = new Center(ply[1], Float.parseFloat(ply[29]), Float.parseFloat(ply[23]), Float.parseFloat(ply[24]), Float.parseFloat(ply[26]), Float.parseFloat(ply[25]), Integer.parseInt(ply[3]), ply[4], Integer.parseInt(ply[5]));
                                 break;
                             case "SG":
                                 player = new ShootingGuard(ply[1], Float.parseFloat(ply[29]), Float.parseFloat(ply[23]), Float.parseFloat(ply[24]), Float.parseFloat(ply[26]), Float.parseFloat(ply[25]), Integer.parseInt(ply[3]), ply[4], Integer.parseInt(ply[5]));
                                 break;
                         }
                         
                         if (player != null) {
                             players.add(player);
                         }
                     }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return filterPlayers(players);
    }
    
    private static ArrayList<Player> filterPlayers(ArrayList<Player> allPlayers) {
        Map<String, Player> playerMap = new HashMap<>();
        for (Player player : allPlayers) {
            if ("TOT".equals(player.getTeam()) || !playerMap.containsKey(player.getPlayerName())) {
                playerMap.put(player.getPlayerName(), player);
            }
        }

        return new ArrayList<>(playerMap.values());
    }
    
    

	private void setSteals(float steals) {
		this.steals = steals;
	}

	private void setBlocks(float blocks) {
		this.blocks = blocks;
	}

	private void setTotalRebounds(float totalRebounds) {
        this.totalRebounds = totalRebounds;
	}

	private void setPoints(float points) {
        this.points = points;
	}

	private void setAge(int age) {
		this.age= age;
	}

	private void setAssists(float assists) {
        this.assists = assists;
	}

	private void setGames(int games) {
		this.games = games;
		
	}

	private void setTeam(String team) {
		this.team = team;
		
	}

	private void setPosition(String position) {
        this.position = position;
	}

	private void setName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPosition() {
		return position;
	}

	public int getAge() {
		return age;
	}

	public String getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

}
