import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        User.readUsersFromFile("users.txt");
        String filePath = "src/2022-2023 NBA Player Stats - Regular.csv";
        ArrayList<Player> allplayers = Player.readPlayersFromCSV(filePath);
        Team.setAllplayers(allplayers);
        Team.CreateTeams();
        SignUp frame = new SignUp();
        frame.setUndecorated(true);
        frame.setVisible(true);
        Match.Match(Team.getTeam(), Team.getOpteam());
    }
}