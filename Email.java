package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 11;
	private String alternateEmail;
	private String companySuffix = "kaalvoet.za";
	
	
		//Constructor for first and last name:
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATE: " + this.firstName + " " + this.lastName);
		
		//call method for department ad return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		//call method for random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		//add it all into a mixing bowl and stir
		email = firstName.toLowerCase() +"."+lastName.toLowerCase() +"@"+ department +"."+ companySuffix;
		System.out.println("Your email");
	}
	
	// ask for department info. create setter. 
	private static String setDepartment() {
		System.out.println("Enter your department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		try (Scanner in = new Scanner(System.in)) {
			int depChoice = in.nextInt();
			if (depChoice == 1) { return "sales"; }
			else if (depChoice ==2) { return "dev"; }
			else if (depChoice == 3) { return "acct"; }
			else { return " "; }
		}
		
	}
	
	// random password generator
	private static String randomPassword(int length) {
		String passwordSet = "0987654321ASDFGHJKLQWERTYUIOPZXCVBNM,.<>?:;[]{}|=+-_)(*&^%$#@!~";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rando = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rando);
			}
		return new String(password);
		
	}
	
	//sets
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	public void  changePassword(String password) {
		this.password = password;
	}
	//gets
	public int getMailboxcapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {return "DISPLAY NAME: " + firstName + " " + lastName + "\n " + "COMAPANY EMAIL: " + email + "\nMAILBOX CAPACITY " + mailboxCapacity +"mb";
	
}
}
