package bankVersion2;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BankmainApp {
	
	 static List<Users> users = new ArrayList<Users>();
	
	 static void selectOpt() throws FileNotFoundException, IOException, ClassNotFoundException {
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
			@SuppressWarnings("unused") 
			UpdateAccout ua=new UpdateAccout(users);
		
			break;
		case 4:
			System.out.println("Your exit from application");
			break;
		}

	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//users.add(new Users("Raghu", "Tumakur", "9897888766", "raghu123", "Raghu@123", 20000, "2021-45-14 01:45:55"));
		//users.add(new Users("Vasu", "Mysore", "9877833766", "vasu123", "Vasu@123", 10000, "2021-42-14 01:42:08"));
		
		selectOpt();
	}

}
