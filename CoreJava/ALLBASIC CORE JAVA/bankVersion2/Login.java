package bankVersion2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Login {

	String username;
	String password;
	List<Users> users;

	Scanner sc = new Scanner(System.in);
	ObjectInputStream ois = null;
	String inputFile = "BankDB/usersdb.db";

	public Login(List<Users> users2) {
		this.users = users2;
		System.out.println();
	}

	void loginAcc() throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.print("Enter username:");
		username = sc.next();
		System.out.print("Enter password:");
		password = sc.next();
		int f = 0;
		ois = new ObjectInputStream(new FileInputStream(inputFile));

		try {

			while (true) {
				Users user1 = (Users) ois.readObject();
				// decoding

				Base64.Decoder decoder = Base64.getDecoder();// java 8 feature Base64 ecryption and decryption
				// System.out.println(user1.getPassword());
				String decypassword = new String(decoder.decode(user1.getPassword()));
				if (user1.getUsername().equals(username) && decypassword.equals(password)) {
					f = 1;
					UserDashboard ud = new UserDashboard(username, users);
					System.out.println("Lagin successfully");
					ud.Dashboard();
					break;
				}

			}

		} catch (EOFException e) {
			// System.out.println("End of file....");
			if (f == 0) {
				System.err.println("invalid user try again...");
				BankmainApp.selectOpt();
			}
		}
	}

}
