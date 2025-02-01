import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MatchGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchGUI frame = new MatchGUI();
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
	Color DefaultColor, ClickedColor;
	public MatchGUI() {
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
		lblNewLabel.setIcon(new ImageIcon(MatchGUI.class.getResource("/images/logouttt.png")));
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
		teampanel.setBackground(DefaultColor);
		matchpanel.setBackground(ClickedColor);
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
		lblNewLabel_1.setIcon(new ImageIcon(MatchGUI.class.getResource("/images/playerdefaultphoto.png")));
		lblNewLabel_1.setBounds(10, 0, 154, 44);
		profilepanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Team");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openTeamFrame();
            }

			private void openTeamFrame() { 
				TeamGUI teamframe = new TeamGUI();
		        teamframe.setUndecorated(true);
		        teamframe.setVisible(true);
		        teamframe.show();
		        dispose();
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon(MatchGUI.class.getResource("/images/basketball-ball.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 0, 154, 44);
		teampanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Match");
		lblNewLabel_1_2.setIcon(new ImageIcon(MatchGUI.class.getResource("/images/basketball (1).png")));
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
		lblNewLabel_1_3.setIcon(new ImageIcon(MatchGUI.class.getResource("/images/season.png")));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 0, 154, 44);
		seasonpanel.add(lblNewLabel_1_3);
		
	}

}
