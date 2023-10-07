package bankVersion2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	ArrayList<String> transactions;

	public RegisterAccount(List<Users> users) {
		this.users = users;
	}

	void enterDetails() throws FileNotFoundException, IOException {

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
			if (password.length() >= 8) {
				if (password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_])).{8,20}")) {
					// one Uppercase,one digit, one sepecial characters must and minimum 8
					// characters legnth
					break;

				} else {
					System.err.println("please enter valid password");
				}

			} else {
				System.err.println("please enter valid password");
			}
		}
		System.out.print("Enter intial Deposit:");
		intdeptamt = sc.nextDouble();


		LocalDateTime date = LocalDateTime.now(); // java 8 feature LocalDateTime
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
		initdate = date.format(dateformat);

		ObjectOutputStream oos = null;
		String outputFile = "BankDB/usersdb.db";
		oos = new ObjectOutputStream(new FileOutputStream(outputFile)); // serialization concept
		// System.out.println(date);
		try {

			Base64.Encoder encoder = Base64.getEncoder(); // java 8 feature Base64 ecryption and decryption
			String encyPassword = encoder.encodeToString(password.getBytes());
			users.add(new Users(name, address, contactno, username, encyPassword, intdeptamt, initdate));

			for (Users user : users)
				oos.writeObject(user);
			// System.out.println("serialization done");

			transactions = new ArrayList<String>(5);

			UserDashboard ud = new UserDashboard(transactions);
			ud.addTransaction(String.format("Initial deposit - " + intdeptamt + " as on " + initdate));
			System.out.println("User Register sucsessfuly");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
