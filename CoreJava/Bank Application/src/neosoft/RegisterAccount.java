package neosoft;

import java.util.*;

public class RegisterAccount {

	Scanner sc = new Scanner(System.in);

	String name;
	String address;
	String contactno;
	String username;
	String password;
	double intdeptamt;
	String initdate;
	List<Users> users;
	public RegisterAccount(List<Users> users) {
		this.users=users;
	}
	void enterDetails() {

		System.out.print("Enter name:");
		name = sc.nextLine();
		System.out.print("Enter address:");
		address = sc.nextLine();
		while (true) {
			System.out.print("Enter Contact number:");
			contactno = sc.next(); // pattern for countryCode: ^[+]\\d{2,3}[-]\\d{10}
			if (contactno.matches("\\d{10}") == false) {
				System.err.println("Please Enter valid contact number");
				continue;
			} else {
				break;
			}
		}
		System.out.print("Enter username:");
		username = sc.next();

		while (true) {
			System.out.print("Enter password:");
			password = sc.next();
			if (password.length() >= 8)
				if (password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_])).{8,20}")) {
					// one Uppercase,one digit, one sepecial characters must and minimum 8
					// characters legnth
					break;

				} else {
					System.err.println("please enter valid password");
				}
		}
		System.out.print("Enter intial Deposit:");
		intdeptamt = sc.nextDouble();
		try {
			
			users.add(new Users(name, address, contactno, username, password, intdeptamt, initdate));
			System.out.println("User register sucsessfuly");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
