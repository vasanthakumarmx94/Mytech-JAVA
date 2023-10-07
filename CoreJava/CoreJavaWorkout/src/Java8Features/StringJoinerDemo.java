package Java8Features;

import java.util.StringJoiner;

public class StringJoinerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringJoiner strjoiner=new StringJoiner("-","[","]");
		strjoiner.add("abc");
		strjoiner.add("vasu");
		strjoiner.add("gmail");
		System.out.println(strjoiner);
		
		StringJoiner strjoiner2=new StringJoiner(":","(",")");
		strjoiner2.add("abc");
		strjoiner2.add("vasu");
		strjoiner2.add("gmail");
		System.out.println(strjoiner2);
		System.out.println(strjoiner2.length());
		System.out.println(strjoiner2.toString().charAt(3));
		System.out.println(strjoiner.merge(strjoiner2));
	
	}

}
