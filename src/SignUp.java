import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameinput;
	private JTextField surnameinput;
	private JTextField ageinput;
	private JTextField emailinput;
	private JTextField nicknameinput;
	private JLabel lblSurname;
	private JLabel lblAge;
	private JLabel lblEmailAddress;
	private JLabel lblNickname;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnValidate_3;
	private JButton btnValidate_2;
	private JButton btnValidate_1;
	private JButton btnValidate;
	private JLabel errormessage_1;
	private JLabel errormessage_2;
	private JLabel errormessage_3;
	private JLabel errormessage_4;
	private JLabel errormessage_5;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private static User signedupuser;

	public static User getSignedupuser() {
		return signedupuser;
	}

	public void setSignedupuser(User signedupuserr) {
		if (signedupuser == null) {
			signedupuser = new User(); 
		    }
		signedupuser.setName(signedupuserr.getName());
		signedupuser.setSurname(signedupuserr.getSurname());
		signedupuser.setNickname(signedupuserr.getNickname());
		signedupuser.setEmail(signedupuserr.getEmail());
		signedupuser.setAge(signedupuserr.getAge());
		signedupuser.setPassword(signedupuserr.getPassword());	
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		User.readUsersFromFile("users.txt");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setUndecorated(true);
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 66, 138));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 384, 569);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(0, 47, 384, 236);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/nba--logo.jpg")));
		

		lblNewLabel_2 = new JLabel("GAME SIMULATION");
		lblNewLabel_2.setForeground(new Color(200, 16, 46));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(28, 267, 346, 67);
		panel.add(lblNewLabel_2);
		
		
		Label label = new Label("Already have an account?");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(107, 372, 193, 16);
		panel.add(label);
		
		
		Button button_1 = new Button("Sign In         ");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setBackground(new Color(200, 16, 46));
		button_1.setBounds(107, 394, 179, 30);
		button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSignInFrame();
            }

			private void openSignInFrame() { 
				SignIn signInFrame = new SignIn();
		        signInFrame.setUndecorated(true);
		        signInFrame.setVisible(true);
		        signInFrame.show();
		        dispose();
			}
        });
		panel.add(button_1);
		
		
		//Name
		nameinput = new JTextField();
		nameinput.setBounds(493, 59, 298, 30);
		contentPane.add(nameinput);
		nameinput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(494, 40, 138, 19);
		contentPane.add(lblNewLabel);
		
		JLabel errormessage = new JLabel("");
		errormessage.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage.setForeground(Color.WHITE);
		errormessage.setBounds(550, 40, 241, 19);
		contentPane.add(errormessage);
		
		btnNewButton = new JButton("validate");
		btnNewButton.setBounds(801, 63, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameInput = nameinput.getText();
				if(User.isNameValid(nameInput)== true) {
					errormessage.setText("(Name is valid)");
				}else {
					errormessage.setText("(Name must consist of at least 3 letters)");
				}
			}
		});
		contentPane.add(btnNewButton);
		
		//Surname
		surnameinput = new JTextField();
		surnameinput.setColumns(10);
		surnameinput.setBounds(493, 117, 298, 30);
		contentPane.add(surnameinput);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(493, 99, 138, 19);
		contentPane.add(lblSurname);
		
		errormessage_1 = new JLabel("");
		errormessage_1.setForeground(Color.WHITE);
		errormessage_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage_1.setBounds(550, 99, 241, 19);
		contentPane.add(errormessage_1);

		btnNewButton_1 = new JButton("validate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String surnameInput = surnameinput.getText();
				if(User.isSurnameValid(surnameInput)== true) {
					errormessage_1.setText("(Surame is valid)");
				}else {
					errormessage_1.setText("(Surname must consist of at least 3 letters)");
				}
			}
		});
		btnNewButton_1.setBounds(801, 121, 85, 21);
		contentPane.add(btnNewButton_1);
		
		//Age
		ageinput = new JTextField();
		ageinput.setColumns(10);
		ageinput.setBounds(493, 175, 298, 30);
		contentPane.add(ageinput);

		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(493, 157, 138, 19);
		contentPane.add(lblAge);
		
		errormessage_2 = new JLabel("");
		errormessage_2.setForeground(Color.WHITE);
		errormessage_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage_2.setBounds(550, 157, 241, 19);
		contentPane.add(errormessage_2);
		
		btnValidate_3 = new JButton("validate");
		btnValidate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ageInput = ageinput.getText();
				if(User.isAgeValid(ageInput)== true) {
					errormessage_2.setText("(Age is valid)");
				}else {
					errormessage_2.setText("(Minimum age limit is 12!)");
				}
			}
		});
		btnValidate_3.setBounds(801, 179, 85, 21);
		contentPane.add(btnValidate_3);
		
		//Email
		emailinput = new JTextField();
		emailinput.setColumns(10);
		emailinput.setBounds(493, 233, 298, 30);
		contentPane.add(emailinput);

		lblEmailAddress = new JLabel("Email");
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setBounds(493, 215, 138, 19);
		contentPane.add(lblEmailAddress);
		
		errormessage_3 = new JLabel("");
		errormessage_3.setForeground(Color.WHITE);
		errormessage_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage_3.setBounds(550, 215, 241, 19);
		contentPane.add(errormessage_3);
		
		btnValidate_2 = new JButton("validate");
		btnValidate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailInput = emailinput.getText();
				if(User.isEmailUnique(emailInput)== true) {
					if(User.isEmailValid(emailInput)== true) {
						errormessage_3.setText("(Email is valid)");
					}else {
						errormessage_3.setText("(Email is not in correct format as name@domain.com)");
					}
				}else {
					errormessage_3.setText("(This email is used by another user)");
				}
			}
		});
		btnValidate_2.setBounds(801, 237, 85, 21);
		contentPane.add(btnValidate_2);
		
		
		//Nickname
		nicknameinput = new JTextField();
		nicknameinput.setColumns(10);
		nicknameinput.setBounds(493, 291, 298, 30);
		contentPane.add(nicknameinput);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setBounds(494, 273, 138, 19);
		contentPane.add(lblNickname);
		
		errormessage_4 = new JLabel("");
		errormessage_4.setForeground(Color.WHITE);
		errormessage_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage_4.setBounds(550, 273, 241, 19);
		contentPane.add(errormessage_4);
		
		btnValidate_1 = new JButton("validate");
		btnValidate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nicknameInput = nicknameinput.getText();
				if(User.isNicknameUnique(nicknameInput)) {
					if(User.isNicknameValid(nicknameInput)== true) {
						errormessage_4.setText("(Nickname is valid)");
					}else {
						errormessage_4.setText("(Nickname must consist of letters and digits only)");
					}
				}else {
					errormessage_4.setText("(This Nickname is used by another user)");
				}
			}
		});
		btnValidate_1.setBounds(801, 295, 85, 21);
		contentPane.add(btnValidate_1);
		
		
		//Password
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(493, 331, 138, 19);
		contentPane.add(lblPassword);
		
		errormessage_5 = new JLabel("");
		errormessage_5.setForeground(Color.WHITE);
		errormessage_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		errormessage_5.setBounds(560, 331, 326, 19);
		contentPane.add(errormessage_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(493, 347, 298, 30);
		contentPane.add(passwordField);
		
		btnValidate = new JButton("validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordInput = passwordField.getText();
				if(User.isPasswordValid(passwordInput)== true) {
					errormessage_5.setText("(Password is valid)");
				}else {
					errormessage_5.setText("(Password must consist of 8 charachters at least one letter, digit and special character)");
				}
			}
		});
		btnValidate.setBounds(801, 353, 85, 21);
		contentPane.add(btnValidate);

		
		Button signup = new Button("Sign Up          ");
		signup.setFont(new Font("Dialog", Font.BOLD, 13));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nicknameInput = nicknameinput.getText();
				String nameInput = nameinput.getText();
				String surnameInput = surnameinput.getText();
				String passwordInput = passwordField.getText();
				String emailInput = emailinput.getText();
				String ageInputstr = ageinput.getText();
				int ageinput = Integer.parseInt(ageInputstr);
				
				User.saveUserToFile(nicknameInput, passwordInput, nameInput, surnameInput, ageinput, emailInput);
				setSignedupuser(User.findUser(nicknameInput));
				User.lastuser = signedupuser;
				Dashboard dashboard = new Dashboard();
				dashboard.setUndecorated(true);
				dashboard.setVisible(true);
				dashboard.show();
		        dispose();
			}
		});
		signup.setForeground(new Color(255, 255, 255));
		signup.setBackground(new Color(200, 16, 46));
		signup.setBounds(550, 394, 179, 30);
		contentPane.add(signup);
		
		
	}

}
