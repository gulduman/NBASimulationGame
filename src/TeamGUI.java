import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamGUI frame = new TeamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DefaultListModel<String> listModel;
	Color DefaultColor, ClickedColor;
	private JTextField selectedplayer;
	public TeamGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 896, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(200, 16, 46));
		panel_2.setBounds(0, 0, 965, 67);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("NBA Game Simulation");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 21, 261, 25);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(848, 21, 38, 36);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/logouttt.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		DefaultColor = new Color(29, 66, 138);
		ClickedColor = new Color(200, 16, 46);
		
		
		JPanel panelswitch = new JPanel();
		panelswitch.setBackground(new Color(255, 255, 255));
		panelswitch.setBounds(174, 66, 722, 425);
		panel.add(panelswitch);
		panelswitch.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Your Team");
		lblNewLabel_3.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/team.png")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(62, 10, 235, 60);
		panelswitch.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Opponent Team");
		lblNewLabel_3_1.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/basketball-players.png")));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3_1.setBounds(62, 212, 235, 50);
		panelswitch.add(lblNewLabel_3_1);
		
		JLabel C = new JLabel("- ");
		C.setFont(new Font("Tahoma", Font.PLAIN, 18));
		C.setBounds(62, 73, 202, 20);
		panelswitch.add(C);
		
		JLabel PG = new JLabel("- ");
		PG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PG.setBounds(62, 96, 202, 20);
		panelswitch.add(PG);
		
		JLabel PF = new JLabel("- ");
		PF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PF.setBounds(62, 119, 202, 20);
		panelswitch.add(PF);
		
		JLabel SG = new JLabel("- ");
		SG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SG.setBounds(62, 142, 202, 20);
		panelswitch.add(SG);
		
		JLabel SF = new JLabel("- ");
		SF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SF.setBounds(62, 163, 202, 20);
		panelswitch.add(SF);
		
		JLabel opC = new JLabel("- ");
		opC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opC.setBounds(62, 265, 202, 20);
		panelswitch.add(opC);
		
		JLabel opPG = new JLabel("- ");
		opPG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opPG.setBounds(62, 288, 202, 20);
		panelswitch.add(opPG);
		
		JLabel opPF = new JLabel("- ");
		opPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opPF.setBounds(62, 311, 202, 20);
		panelswitch.add(opPF);
		
		JLabel opSG = new JLabel("- ");
		opSG.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opSG.setBounds(62, 334, 202, 20);
		panelswitch.add(opSG);
		
		JLabel opSF = new JLabel("- ");
		opSF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opSF.setBounds(62, 355, 202, 20);
		panelswitch.add(opSF);
		
		JLabel listtitle = new JLabel("Available Players for Center");
		listtitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		listtitle.setBounds(362, 10, 350, 20);
		panelswitch.add(listtitle);
		
		
		JList list = new JList();
		list.setBounds(380, 38, 296, 270);
		panelswitch.add(list);
		list.setBackground(new Color(217, 217, 217));
		listModel = new DefaultListModel<>();
		List<Player> centerlist = Team.getCPlayerList();
		for(Player player: centerlist) {
			listModel.addElement(player.getPlayerName());
			list.setModel(listModel);
		}	
		
		JLabel lblNewLabel_6 = new JLabel("Selected Player Name:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(385, 318, 196, 20);
		panelswitch.add(lblNewLabel_6);
		
		selectedplayer = new JTextField();
		selectedplayer.setBounds(385, 344, 196, 28);
		panelswitch.add(selectedplayer);
		selectedplayer.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Add this player to your team");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i ==0) {
					i++;
					C.setText(selectedplayer.getText());
					opC.setText(Team.addSFplayers(selectedplayer.getText()).getPlayerName());
					listModel.clear();
					listtitle.setText("Available Players for Point Guard");
					List<Player> centerlist = Team.getPGPlayerList();
					for(Player player: centerlist) {
						listModel.addElement(player.getPlayerName());
						list.setModel(listModel);
					}
					
				}else if(i==1) {
					Team.addPGplayers(selectedplayer.getText());
					i++;
					PG.setText(selectedplayer.getText());
					opPG.setText(Team.addSFplayers(selectedplayer.getText()).getPlayerName());
					listModel.clear();
					listtitle.setText("Available Players for Point Forward");
					List<Player> centerlist = Team.getPFPlayerList();
					for(Player player: centerlist) {
						listModel.addElement(player.getPlayerName());
						list.setModel(listModel);
					}
				}else if(i==2) {
					Team.addPFplayers(selectedplayer.getText());
					i++;
					PF.setText(selectedplayer.getText());
					opPF.setText(Team.addSFplayers(selectedplayer.getText()).getPlayerName());
					listModel.clear();
					listtitle.setText("Available Players for Shooting Guard");
					List<Player> centerlist = Team.getSGPlayerList();
					for(Player player: centerlist) {
						listModel.addElement(player.getPlayerName());
						list.setModel(listModel);
					}
				}else if(i==3) {
					Team.addSGplayers(selectedplayer.getText());
					i++;
					SG.setText(selectedplayer.getText());
					opSG.setText(Team.addSFplayers(selectedplayer.getText()).getPlayerName());
					listModel.clear();
					listtitle.setText("Available Players for Small Forward");
					List<Player> centerlist = Team.getSFPlayerList();
					for(Player player: centerlist) {
						listModel.addElement(player.getPlayerName());
						list.setModel(listModel);
					}
				}else if(i==4){
					Team.addSFplayers(selectedplayer.getText());
					SF.setText(selectedplayer.getText());
					opSF.setText(Team.addSFplayers(selectedplayer.getText()).getPlayerName());
					Team.displayTeams();
				}
			}
		});
		btnNewButton.setBounds(385, 382, 163, 20);
		panelswitch.add(btnNewButton);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(29, 66, 138));
		panel_1.setBounds(0, 66, 174, 504);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel profilepanel = new JPanel();
		profilepanel.setBackground(new Color(29, 66, 138));
		profilepanel.setForeground(new Color(255, 255, 255));
		profilepanel.setBounds(0, 33, 174, 46);
		panel_1.add(profilepanel);
		profilepanel.setLayout(null);
		
		JPanel teampanel = new JPanel();
		teampanel.setLayout(null);
		teampanel.setForeground(Color.WHITE);
		teampanel.setBackground(new Color(29, 66, 138));
		teampanel.setBounds(0, 88, 174, 46);
		panel_1.add(teampanel);
		
		JPanel matchpanel = new JPanel();
		matchpanel.setLayout(null);
		matchpanel.setForeground(Color.WHITE);
		matchpanel.setBackground(new Color(29, 66, 138));
		matchpanel.setBounds(0, 144, 174, 46);
		panel_1.add(matchpanel);
		
		JPanel seasonpanel = new JPanel();
		seasonpanel.setLayout(null);
		seasonpanel.setForeground(Color.WHITE);
		seasonpanel.setBackground(new Color(29, 66, 138));
		seasonpanel.setBounds(0, 197, 174, 46);
		panel_1.add(seasonpanel);
		

		profilepanel.setBackground(DefaultColor);
		teampanel.setBackground(ClickedColor);
		matchpanel.setBackground(DefaultColor);
		seasonpanel.setBackground(DefaultColor);
		

		
		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openDashboardFrame();
            }

			private void openDashboardFrame() { 
				Dashboard profileGUI = new Dashboard();
		        profileGUI.setUndecorated(true);
		        profileGUI.setVisible(true);
		        profileGUI.show();
		        dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/playerdefaultphoto.png")));
		lblNewLabel_1.setBounds(10, 0, 154, 44);
		profilepanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Team");
		lblNewLabel_1_1.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/basketball-ball.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 0, 154, 44);
		teampanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Match");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMatchFrame();
            }

			private void openMatchFrame() { 
				MatchGUI matchframe = new MatchGUI();
		        matchframe.setUndecorated(true);
		        matchframe.setVisible(true);
		        matchframe.show();
		        dispose();
			}
		});
		lblNewLabel_1_2.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/basketball (1).png")));
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 0, 154, 44);
		matchpanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Season");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openSeasonFrame();
            }

			private void openSeasonFrame() { 
				SeasonGUI seasonframe = new SeasonGUI();
		        seasonframe.setUndecorated(true);
		        seasonframe.setVisible(true);
		        seasonframe.show();
		        dispose();
			}
		});
		lblNewLabel_1_3.setIcon(new ImageIcon(TeamGUI.class.getResource("/images/season.png")));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 0, 154, 44);
		seasonpanel.add(lblNewLabel_1_3);
		
	}
}
