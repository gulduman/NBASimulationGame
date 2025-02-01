
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class User {
	private String nickname ;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String email;
    private ImageIcon profilePhoto;
    private static List<User> users = new ArrayList<>();
    public static User lastuser;
    
    public static List<User> readUsersFromFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                User user = new User(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Users from " + filePath + " are read.");
        return users;
        
	}
 
    // Getter methods
    public String getNickname() {
        return nickname;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public ImageIcon getProfilePhoto() {
		return profilePhoto;
    }
    public static List<User> getUsers() {
		return users;
	}
    
    //Setter methods:
    public void setProfilePhoto(ImageIcon profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
    public void setAge(int age) {
    	this.age = age;
	}
    public void setEmail(String email) {
    	this.email= email;
	}
    
    public void setName(String name2) {
		this.name = name2;
	}

	public void setSurname(String surname2) {
		this.surname = surname2;
	}

	public void setNickname(String nickname2) {
		this.nickname = nickname2;
	}
	public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    
    //Sign Up
    public static Boolean isNameValid(String Name) {
        boolean x = false;
        String n = Name;
        try {
            if (n.matches("^[a-zA-Z]{3,}$")) {
                x = true;
            }
        } catch (Exception e) {
            x = false;
        }
        
        if(x== true) {
        	return true;
        }else {
        	return false;
        }
    } 
    
    public static boolean isSurnameValid(String s) {
    	 boolean x = false;
         try {
             if (s.matches("^[a-zA-Z]{3,}$")) {
                 x = true;
             }
         } catch (Exception e) {
        	 x = false;
         }
         if(x== true) {
         	return true;
         }else {
         	return false;
         }
	}
  
    public static boolean isAgeValid(String b) {
    	boolean x = false;
    	int a = 0;
    	a = Integer.parseInt(b);
    	try{
    		if(a>= 12) {
        		x = true;
        	}
    	}catch (Exception e) {
    		x = false;
    	}
        if(x== true) {
        	return true;
        }else {
        	return false;
        }
    }
    
    public static boolean isEmailValid(String emailadd) {
    	boolean x = false;
    	try {
    		if(isEmailUnique(emailadd)) {
				if(emailadd.matches("^[a-zA-Z0-9_]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}$")){
            		x = true;
    			}
    			}}
    	catch (Exception e) {
    		x = false;
    	}
		if(x== true) {
        	return true;
        }else {
        	return false;
        }
    }
    
    public static boolean isEmailUnique(String email) {
	    if (!users.isEmpty()) {
	        for (User user : users) {
	            if (user.getEmail().equals(email)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
    
    public static boolean isNicknameValid(String Nickname) {
    	boolean x = false;
    	try {
    			if (Nickname.matches("^[a-zA-Z0-9]+$")) {
                    x = true;	
    	}}
    	catch (Exception e) {
            x=false;
    	}
    	if(x== true) {
        	return true;
        }else {
        	return false;
        }
    }
    
    public static boolean isNicknameUnique(String nickname) {
    	if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getNickname().equals(nickname)) {
                    return false; // Nickname already exists
                }
            }
        }else {
        	System.out.println("empty");
        }
        return true; // Nickname is unique
    }
    
    public static boolean isPasswordValid(String pass) {
    	boolean x = false;
    	String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
		boolean letter = false;
		boolean digit = false;
		boolean specialchar = false;
		
		try {
			if(pass.length()>=8) {
    			for(int i = 0; i < pass.length(); i++) {
    				if(Character.isLetter(pass.charAt(i))) {
    					letter = true;
    				}else if (Character.isDigit(pass.charAt(i))) {
    					digit = true;
    				}else if(specialCharacters.indexOf(pass.charAt(i))!= -1){
    					specialchar = true;
    				}
    			}
    			if(letter && digit && specialchar) {
    				x=true;
    			}
    		}
		}catch (Exception e) {
			x = false;
		}
		if(x== true) {
        	return true;
		}else {
		return false;
		}
	}  
    
    // Method to save user information to a file
    public static void saveUserToFile(String nick, String p, String n, String s, int a, String e) {
    	User user = new User(nick, p, n, s, a, e);
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt", true))) {
            writer.println(user.getNickname() + "," + user.getPassword() + "," + user.getName() + "," + user.getSurname() + "," + user.getAge() + "," + user.getEmail());
            System.out.println("User succesfully added to the list.");
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
    
    public User(String nick, String p, String n, String s, int a, String e){
        this.nickname = nick;
        this.password = p;
        this.name = n;
        this.surname = s;
        this.age = a;
        this.email = e;
        this.setProfilePhoto(new ImageIcon("defaultprofileimage.png"));
        users.add(this);
    }
    
    //Sign In
    public static User findUser(String nickname) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNickname().equals(nickname)) {
                return users.get(i);
            }
        }
        return null; // User not found
    }

    
    public static boolean doesNicknameExist(String nickname){
    	for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNickname().equals(nickname)) {
                return true;
            }
	}
    return false;
	}
    
    public static boolean doesPasswordMatch(String nickname, String password) {
    	User user = findUser(nickname);
    	if (user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
            return true;
    	}
    	return false;
	}
    
	public static boolean signIn(String enteredNickname, String enteredPass){
	    boolean signInSuccessful = false;		
		if (doesNicknameExist(enteredNickname) && doesPasswordMatch(enteredNickname, enteredPass)) {
			signInSuccessful = true;
		}
		if (signInSuccessful == true) {
			return true;
		}else {
			return false;
		}
		}	
		
	// User Constructors:
    public User(String nickname, String password, String name, String surname, int age, String email, ImageIcon profilePhoto) {
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.setProfilePhoto(profilePhoto);
        users.add(this);
    }
    public User() {
    	  this.name = "";
          this.surname = "";
          this.nickname = "";
          this.email = "";
          this.age = 0;
          this.password = "";
    }

    
    public static void UpdateUser(String nickname2, String nage, String nemail, String npassword) {
		findUser(nickname2);
		int nAge = Integer.parseInt(nage);
		if(isAgeValid(nage)==true) {
			findUser(nickname2).setAge(nAge);;
		}
		if(isEmailValid(nemail)) {
			findUser(nickname2).setEmail(nemail);
		}
		if(isPasswordValid(npassword)) {
			findUser(nickname2).setPassword(npassword);
		}
		
		writeUsersToFile(users);
	}
	

    private static void writeUsersToFile(List<User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.txt"))) {
            for (User user : users) {
                writer.println(user.getNickname() + "," + user.getPassword() + "," + user.getName() +
                		"," + user.getSurname() + "," + user.getAge() + "," + user.getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void UpdateProfilePhoto(String nickname2, ImageIcon pp) {
		findUser(nickname2).setProfilePhoto(pp);
	}

	

	

	

	
}
