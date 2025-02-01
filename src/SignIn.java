import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private static User signedinuser;
	public static int where;

	public static User getSignedinuser() {
		return signedinuser;
	}



	public void setSingedinuser(User signedinuserr) {
		if (signedinuser == null) {
		    signedinuser = new User();
		    }
		signedinuser.setName(signedinuserr.getName());
		signedinuser.setSurname(signedinuserr.getSurname());
		signedinuser.setNickname(signedinuserr.getNickname());
		signedinuser.setEmail(signedinuserr.getEmail());
		signedinuser.setAge(signedinuserr.getAge());
		signedinuser.setPassword(signedinuserr.getPassword());
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 66, 138));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 384, 551);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(0, 47, 384, 236);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/images/nba--logo.jpg")));
		
		Label label = new Label("Do not have an account?");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(107, 372, 193, 16);
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("GAME SIMULATION");
		lblNewLabel_2.setForeground(new Color(200, 16, 46));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_2.setBounds(28, 267, 346, 67);
		panel.add(lblNewLabel_2);
		
		Button button_1 = new Button("Sign Up         ");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setBackground(new Color(200, 16, 46));
		button_1.setBounds(107, 394, 179, 30);
		button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSignUpFrame();
            }

			@SuppressWarnings("deprecation")
			private void openSignUpFrame() {
				SignUp signUpFrame = new SignUp();
		        signUpFrame.setUndecorated(true);
		        signUpFrame.setVisible(true);
		        signUpFrame.show();
		        dispose();
			}
        });
		panel.add(button_1);
		
		
		//Nickname
		JTextField nicknameinput = new JTextField();
		nicknameinput.setColumns(10);
		nicknameinput.setBounds(493, 176, 298, 30);
		contentPane.add(nicknameinput);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(572, 162, 219, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNickname.setForeground(Color.WHITE);
		lblNickname.setBounds(493, 158, 138, 19);
		contentPane.add(lblNickname);
		
		JButton btnNewButton = new JButton("validate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nicknameInput = nicknameinput.getText();
				if(User.doesNicknameExist(nicknameInput)== true) {
					lblNewLabel.setText("(Valid nickname)");
				}else {
					lblNewLabel.setText("(Nickname does not exists)");
				}
			}
		});
		btnNewButton.setBounds(801, 180, 85, 21);
		contentPane.add(btnNewButton);
		
		//Password
		passwordField = new JPasswordField();
		passwordField.setBounds(493, 254, 298, 30);
		contentPane.add(passwordField);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(572, 240, 314, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(493, 236, 138, 19);
		contentPane.add(lblPassword);
		
		JButton btnValidate = new JButton("validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String passwordInput = passwordField.getText();
				String nicknameInput = nicknameinput.getText();
				if(User.doesPasswordMatch(nicknameInput, passwordInput)== true) {
					lblNewLabel_3.setText("(Valid password)");
				}else {
					lblNewLabel_3.setText("(Invalid password)");
				}
			}
		});
		btnValidate.setBounds(801, 258, 85, 21);
		contentPane.add(btnValidate);
		
		
		
		//SignIn
		Button button = new Button("Sign In          ");
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nicknameInput = nicknameinput.getText();
				String passwordInput = passwordField.getText();
				boolean x = User.signIn(nicknameInput, passwordInput);
				if(x==true) {
					setSingedinuser(User.findUser(nicknameInput));
					User.lastuser = signedinuser;
					Dashboard dashboard = new Dashboard();
					dashboard.setUndecorated(true);
					dashboard.setVisible(true);
					dashboard.show();
			        dispose();
	            }
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(200, 16, 46));
		button.setBounds(550, 394, 179, 30);
		contentPane.add(button);
		
		
		
		
		

	}
}
