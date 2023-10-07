package Basics;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.println("Enter Your nmae");
		String name=input.nextLine();
		System.out.println("Hi"+name);
		int age=(int)input.nextDouble();
		
			//Convert into specific type
		System.out.println("enter youe age:");
		String txtAge=input.nextLine();
		int age1=Integer.parseInt(txtAge);
		
		
		
		input.close();
		}

}
