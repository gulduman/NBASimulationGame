

public class Match {
	private static Team homeTeam;
    private static Team awayTeam;

    // Constructor
    public Match(Team team1, Team team2) {
    	homeTeam = team1;
    	awayTeam = team2;
    }
    
	public static void Match(Team team, Team opteam) {
        homeTeam = team;
        awayTeam = opteam;
    }

    // Method to simulate the match
    public Team simulateMatch() {
        // Randomly select the home team to have a slight advantage
        double homeMultiplier = 1.05;
        double homeTeamScore = homeTeam.calculateTeamScore() * homeMultiplier;
        double awayTeamScore = awayTeam.calculateTeamScore();
        if (homeTeamScore > awayTeamScore) {
            homeTeam.incrementWins();
            awayTeam.incrementLosses();
        } else {
            awayTeam.incrementWins();
            homeTeam.incrementLosses();
        }
        // Determine the winning team
        return (homeTeamScore > awayTeamScore) ? homeTeam : awayTeam;
    }

	public Team getWinner() {
        return simulateMatch();
	}

}
