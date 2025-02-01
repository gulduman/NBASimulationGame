import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
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
		panel_2.setBounds(0, 0, 1037, 67);
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
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/images/logouttt.png")));
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
		panelswitch.setBounds(172, 66, 865, 512);
		panel.add(panelswitch);
		panelswitch.setLayout(null);
	
		JTextField namelabel = new JTextField("");
		namelabel.setText(User.lastuser.getName());
		namelabel.setEditable(false);
		namelabel.setBounds(290, 216, 117, 19);
		panelswitch.add(namelabel);
		
		JTextField surnamelabel = new JTextField("");
		surnamelabel.setText(User.lastuser.getSurname());
		surnamelabel.setEditable(false);
		surnamelabel.setBounds(290, 245, 117, 20);
		panelswitch.add(surnamelabel);
		
		JTextField nicknamelabel = new JTextField("");
		nicknamelabel.setText(User.lastuser.getNickname());
		nicknamelabel.setEditable(false);
		nicknamelabel.setBounds(290, 188, 117, 19);
		panelswitch.add(nicknamelabel);
		
		JTextField agelabel = new JTextField("");
		agelabel.setText(String.valueOf(User.lastuser.getAge()));
		agelabel.setBounds(290, 275, 117, 19);
		panelswitch.add(agelabel);
		
		JTextField emaillabel = new JTextField("");
		emaillabel.setText(User.lastuser.getEmail());
		emaillabel.setBounds(290, 307, 117, 19);
		panelswitch.add(emaillabel);
		
		JTextField passwordlabel = new JTextField("");
		passwordlabel.setText(User.lastuser.getPassword());
		passwordlabel.setBounds(290, 339, 117, 16);
		panelswitch.add(passwordlabel);
		
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(89, 216, 98, 17);
		panelswitch.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Surname");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(89, 243, 78, 20);
		panelswitch.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Age");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(89, 273, 78, 20);
		panelswitch.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Email Address");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(89, 303, 117, 20);
		panelswitch.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Nickname");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(89, 185, 98, 20);
		panelswitch.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Password");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_4.setBounds(89, 335, 104, 20);
		panelswitch.add(lblNewLabel_4_4);
		
		JLabel profilepic = new JLabel("New label");
		profilepic.setIcon(new ImageIcon(Dashboard.class.getResource("/images/profiledefaultt.png")));
		profilepic.setBounds(89, 49, 98, 98);
		panelswitch.add(profilepic);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(385, 368, 307, 19);
		panelswitch.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(290, 146, 210, 13);
		panelswitch.add(lblNewLabel_7);
		
		JButton savechangebutton = new JButton("Save Changes");
		savechangebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nage = agelabel.getText();
				String nemail = emaillabel.getText();
				String npassword = passwordlabel.getText();
				String nickname = nicknamelabel.getText();
				if(!User.isEmailValid(nemail)){
					nemail = User.lastuser.getEmail();
				}
				if(!User.isAgeValid(nage)) {
					nage = String.valueOf(User.lastuser.getAge());
				}
				if(!User.isPasswordValid(npassword)) {
					npassword = User.lastuser.getPassword();
				}
				User.UpdateUser(nickname, nage, nemail, npassword);		
				agelabel.setText(nage);
				emaillabel.setText(nemail);
				passwordlabel.setText(npassword);
				lblNewLabel_6.setText("(User info has been updated with valid changes.)");
			}
		});
		savechangebutton.setBounds(461, 337, 104, 21);
		panelswitch.add(savechangebutton);
		
		JTextField ppfilepath = new JTextField();
		ppfilepath.setBounds(290, 89, 127, 19);
		panelswitch.add(ppfilepath);
		ppfilepath.setColumns(10);
		
		JButton btnNewButton = new JButton("change profile photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = nicknamelabel.getText();
				ImageIcon pp = new ImageIcon(ppfilepath.getText());
				profilepic.setIcon(pp);
				lblNewLabel_7.setText("(Profile photo has been changed)");
			
				User.UpdateProfilePhoto(nickname, pp);
			}
		});
		btnNewButton.setBounds(290, 122, 127, 21);
		panelswitch.add(btnNewButton);
		
		
		JLabel lblNewLabel_5 = new JLabel("Enter filepath of new profile photo");
		lblNewLabel_5.setBounds(290, 63, 175, 16);
		panelswitch.add(lblNewLabel_5);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(29, 66, 138));
		panel_1.setBounds(0, 66, 174, 608);
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
		



		profilepanel.setBackground(ClickedColor);
		teampanel.setBackground(DefaultColor);
		matchpanel.setBackground(DefaultColor);
		seasonpanel.setBackground(DefaultColor);
		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/images/playerdefaultphoto.png")));
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
		lblNewLabel_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/images/basketball-ball.png")));
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
		lblNewLabel_1_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/basketball (1).png")));
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
		lblNewLabel_1_3.setIcon(new ImageIcon(Dashboard.class.getResource("/images/season.png")));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 0, 154, 44);
		seasonpanel.add(lblNewLabel_1_3);
		
		
		
	}
}
