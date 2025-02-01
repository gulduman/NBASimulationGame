
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Season {
	private ArrayList<Team> teams;
    private List<Match> matches;


    // Constructor
    public Season(ArrayList<Team> teams) {
        this.teams = teams;
        this.matches = new ArrayList<>();
    }

    
    public void simulateMatches() {
        // Simulate matches for each team
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match(teams.get(i), teams.get(j));
                match.simulateMatch();
                matches.add(match);
            }
        }
    }
    
    public List<Team> getTeamsWithHighestWins(int count) {
        // Sort teams based on wins
        teams.sort((t1, t2) -> Integer.compare(t2.getWins(), t1.getWins()));

        // Return the top 'count' teams
        return teams.subList(0, Math.min(count, teams.size()));
    }
    
    public void simulatePlayoffs() {
        List<Team> playoffTeams = getTeamsWithHighestWins(8);

        // Simulate playoff matches until one team remains
        while (playoffTeams.size() > 1) {
            List<Team> winners = new ArrayList<>();
            for (int i = 0; i < playoffTeams.size(); i += 2) {
                Match playoffMatch = new Match(playoffTeams.get(i), playoffTeams.get(i + 1));
                playoffMatch.simulateMatch();
                winners.add(playoffMatch.getWinner());
            }
            playoffTeams = winners;
        }
    }
    
    // Method to simulate the season
    public Team simulateSeason() {
        int numMatches = teams.size() * 2;
        
        // Simulate normal season matches
        for (int i = 0; i < numMatches; i++) {
            Team homeTeam = teams.get(i % teams.size());
            Team awayTeam = teams.get((i + 1) % teams.size());
            
            Match match = new Match(homeTeam, awayTeam);
            Team winningTeam = match.simulateMatch();
            
            // Update team statistics (wins, losses, etc.)
            updateTeamStats(homeTeam, awayTeam, winningTeam);
        }

        // Select top teams for playoffs
        ArrayList<Team> topTeams = getTopTeams();
        
        // Simulate playoffs
        while (topTeams.size() > 1) {
            ArrayList<Team> nextRoundTeams = new ArrayList<>();
            
            for (int i = 0; i < topTeams.size(); i += 2) {
                Team homeTeam = topTeams.get(i);
                Team awayTeam = topTeams.get(i + 1);
                
                Match playoffMatch = new Match(homeTeam, awayTeam);
                Team winningTeam = playoffMatch.simulateMatch();
                
                nextRoundTeams.add(winningTeam);
            }
            
            topTeams = nextRoundTeams;
        }

        return topTeams.get(0);
    }

    private void updateTeamStats(Team homeTeam, Team awayTeam, Team winningTeam) {
        if (winningTeam == homeTeam) {
            homeTeam.incrementWins();
            awayTeam.incrementLosses();
        } else {
            homeTeam.incrementLosses();
            awayTeam.incrementWins();
        }
    }

    
    private ArrayList<Team> getTopTeams() {
        ArrayList<Team> sortedTeams = new ArrayList<>(teams);
        Collections.sort(sortedTeams, Collections.reverseOrder());

        int numTopTeams = Math.min(8, sortedTeams.size());
        return new ArrayList<>(sortedTeams.subList(0, numTopTeams));
    }

}
