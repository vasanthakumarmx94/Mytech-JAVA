package MyTask;

import java.util.*;

public class ListDemos {

	public static void main(String[] args) {
		List<Employees> alst=new ArrayList<Employees>();
		Scanner sc=new Scanner(System.in);
		final String COMPANY_NAME="NeoSoft Technology";
		
		System.out.println("Enter Employee details to store:");
		System.out.println("Enter Employee ID:");
		int empid=sc.nextInt();
		System.out.println("Enter Employee Name:");
		String ename=sc.next();
		System.out.println("Enter Employee Address:");
		String address=sc.next();
		System.out.println("Enter Employee Salary:");
		double salary=sc.nextDouble();
		Employees emp=new Employees();
		emp.empid=empid;
		emp.Empname=ename;
		emp.address=address;
		emp.cmpname=COMPANY_NAME;
		emp.salary=salary;
		

	}

}
