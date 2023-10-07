package neosoft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankmainApp {
	static int cursor = 1;
	static List<Users> users = new ArrayList<Users>();

	public static void main(String[] args) {
		users.add(new Users("Raghu", "Tumakur", "9897888766", "raghu123", "Raghu@123", 20000, "05-10-2021"));
		users.add(new Users("Vasu", "Mysore", "9877833766", "vasu123", "Vasu@123", 10000, "05-09-2021"));
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
		RegisterAccount rg;
		selectOpt();
	}

	static void selectOpt() {
		EnterBOption Eo = new EnterBOption();
		int option = Eo.selectOption();
		switch (option) {
		case 1:
			RegisterAccount rg = new RegisterAccount(users);
			rg.enterDetails();
			selectOpt();
			break;
		case 2:
			 Login lg = new Login(users);
			 lg.loginAcc();
			break;
		case 3:

			break;
		case 4:
			System.out.println("Your exit from application");
			break;
		}

	}
}
