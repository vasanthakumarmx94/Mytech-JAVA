package neosoft;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ener password:");
		String pass=sc.next();
		//	((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,8})
		//System.out.println(pass.matches("(([A-z])+ ([!@#$%^&*_])+(\\d+)).{8,8}"));
		System.out.println(pass.matches("(\\d[A-Z][!@#$%^&*_]).{8,8}"));
		
		
		
		System.out.println(pass.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_])).{6,20}"));
		
		
		//System.out.println(pass.matches("^((?=.*\\d+)(?=.*[A-Z]+)(?=.*[!@#$%^&*_]).{8,8})$"));
		
	}

}
