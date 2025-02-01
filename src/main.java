import java.util.ArrayList;
import java.util.Collections;

/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Gül Duman, 80191>
*************************************************************************/


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