package neosoft;

import java.util.List;
import java.util.Scanner;

public class UserDashboard {

	Scanner sc = new Scanner(System.in);
	int depamt;
	int tramt;
	String payname;
	String username;
	List<Users> users;
	Users u;

	public UserDashboard(String username, List<Users> users) {
		this.users = users;
		this.username = username;
	}

	void Dashboard() {
		EnterBOption Eo = new EnterBOption();
		int option1 = Eo.userOption();

		switch (option1) {
		case 1:
			deposit();
			Dashboard();
			break;
		case 2:
			transfer();
			Dashboard();
			break;
		case 3:
			
			break;
		case 4:
			userInfo();
			Dashboard();
			break;
		case 5:
			// BankmainApp bkm=new BankmainApp();
			System.out.println("THANK YOU.....");
			BankmainApp.selectOpt();
			break;
		}
	}

	void deposit() {
		System.out.println("Enter amount:");
		depamt = sc.nextInt();
		for (Users user : users) {
			// System.out.println("Name:"+user.name+", Username:"+user.username+",
			// balance:"+user.intdeptamt+", uuu"+this.username);
			if (user.username.equals(username)) {
				user.intdeptamt = user.intdeptamt + depamt;
				
				System.out.println(depamt + " Deposited successfully to " + user.name);
				// System.out.println(user.intdeptamt);
			}
		}

	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.username+" ,"+user;
//	}

	void userInfo() {
		for (Users user : users) {
			if (user.username.equals(username)) {
				System.out.println("Account Holder Name:" + user.name);
				System.out.println("Account Holder Address:" + user.address);
				System.out.println("Account Holder contact:" + user.contactno);
			}
		}

	}

	void transfer() {
		System.out.println("Enter payee Uname :");
		payname = sc.next();
		System.out.println("Enter transfer amount:");
		tramt = sc.nextInt();
		int f = 0;
		for (Users user : users) {
			//System.out.println("Name:" + user.name + ", Username:" + user.username + ", balance:" + user.intdeptamt);
			if (payname.equals(user.username)) {
				user.intdeptamt = user.intdeptamt + tramt;
				System.out.println(tramt+" transfer to "+payname);
				f = 1;
			} 
		}
		if (f == 1) {
			for (Users user : users) {
				if (username.equals(user.username)) {
					user.intdeptamt = user.intdeptamt - tramt;
					System.out.println("Your Balance is:"+user.intdeptamt);
				}
			}
		}else {
			System.err.println("User does not exists");
		}
	}
}
