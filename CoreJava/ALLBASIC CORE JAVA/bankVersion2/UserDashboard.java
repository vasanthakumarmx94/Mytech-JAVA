package bankVersion2;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BankApp.BankmainApp;

public class UserDashboard {

	Scanner sc = new Scanner(System.in);
	int depamt;
	int tramt;
	String payuname;
	String username;

	List<Users> users;
	public static ArrayList<String> transactions;
	Users u;

	public UserDashboard(String username, List<Users> users) {
		this.users = users;
		this.username = username;
	}

	public UserDashboard(ArrayList<String> transactions2) {
		transactions = transactions2;

	}

	void Dashboard() throws FileNotFoundException, IOException, ClassNotFoundException {
		EnterBOption Eo = new EnterBOption();
		int option1 = Eo.userOption();

		switch (option1) {
		case 1:
//			Date date = Calendar.getInstance().getTime();
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//			String initdate = dateFormat.format(date);

			LocalDateTime date = LocalDateTime.now(); // java 8 feature LocalDateTime
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
			String initdate = date.format(dateformat);
			deposit(initdate);
			Dashboard();
			break;
		case 2:
			viewbalance();
			Dashboard();
			break;
		case 3:
			transfer();
			Dashboard();
			break;
		case 4:
			for (String transaction : transactions) {
				System.out.println(transaction);
			}
			Dashboard();
			break;
		case 5:
			userInfo();
			Dashboard();
			break;
		case 6:
			// BankmainApp bkm=new BankmainApp();
			System.out.println("THANK YOU.....");
			BankmainApp.selectOpt();
			break;
		}
	}

	private void viewbalance() throws FileNotFoundException, IOException, ClassNotFoundException {
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BankDB/usersdb.db"));

		while (true) {
			Users use = (Users) ois.readObject();
			if (use.getUsername().equals(username)) {
				System.out.println("Your Bank Balance:" + use.getBalance());
				break;
			}

		}

	}

	/* deposit to user accout by retriving inf. from userdb.db file and store */

	void deposit(String initdate) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Enter amount:");
		depamt = sc.nextInt();
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BankDB/usersdb.db"));

		while (true) {
			Users user = (Users) ois.readObject();
			if (user.getUsername().equals(username)) {

				// double bal=user.setBalance(user.getBalance()+depamt);
				user.balance = user.getBalance() + depamt;
				String outputFile = "BankDB/usersdb.db";
				@SuppressWarnings("resource")
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile));

				for (Users ul : users) {
					if (ul.username.equals(username)) {
						ul.balance = ul.balance + depamt;
					}
				}

				addTransaction(String.format(
						depamt + " credited to your account. Balance = " + user.balance + " as on " + initdate));

				System.out.println(depamt + " Deposited successfully to " + user.name);

				for (Users u : users)
					oos.writeObject(u);
				break;
			}

		}

	}

	void userInfo() throws FileNotFoundException, IOException {

		@SuppressWarnings("resource") // java 8 feature annotation
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BankDB/usersdb.db"));
		List<Users> lst = new ArrayList<Users>();// created one list and add all objects to it
		try {
			while (true) {
				Users user = (Users) ois.readObject();
				lst.add(user); // add readObject to list lst
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// java 8 feature filter ,stream usage
		lst.stream().filter(el -> el.getUsername().equals(username))
				.forEach(ele -> System.out.println("Account holder Name:" + ele.getName() 
												+ "\n Account holder Address:"+ ele.getAddress() 
												+ "\n Account Holder Contact:" + ele.getContactno()
												+ "\n Account Holder UserName:" + ele.getUsername()));

	}

	public void addTransaction(String message) {
		transactions.add(0, message);
		if (transactions.size() > 5) {
			transactions.remove(5);
			transactions.trimToSize();
		}

	}

	void transfer() throws FileNotFoundException, IOException {
		System.out.print("Enter pay Username :");
		payuname = sc.next();
		System.out.print("Enter transfer amount:");
		tramt = sc.nextInt();
		int f = 0;
		@SuppressWarnings("resource") // java 8 feature annotation

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("BankDB/usersdb.db"));
		try {
			while (true) {
				Users user = (Users) ois.readObject();
				if (user.username.equals(payuname)) {

					// user.balance = user.balance + tramt;
					System.out.println(tramt + " transfer to " + payuname);

					LocalDateTime date1 = LocalDateTime.now(); // java 8 feature LocalDateTime
					DateTimeFormatter dateformat1 = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
					String initdate1 = date1.format(dateformat1);

					addTransaction(String.format(tramt + " transfer to " + payuname + " as on " + initdate1));

					for (Users ul : users) {
						if (payuname.equals(ul.username)) {
							ul.balance = ul.balance + tramt;
							f = 1;
						}

					}
					if (f == 1) {
						for (Users ul : users) {
							if (username.equals(ul.username)) {
								ul.balance = ul.balance - tramt;
								System.out.println("Your Balance is:" + ul.balance);
							}

						}
					}

					@SuppressWarnings("resource")
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BankDB/usersdb.db"));

					for (Users u : users)
						oos.writeObject(u);

					break;
				}

			}
		} catch (EOFException e) {
			if (f == 0) {
				System.err.println("User does not exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
