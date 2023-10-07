package Basics;

import java.util.GregorianCalendar;

public class StringDemo {

	public static void main(String[] args) {
		
		//String are by default immutable
//		String str="Vasantha";
//		str=str.concat("Kumar");//returns new object
//		System.out.println(str);
//		System.out.println("============================================");
//		String s1="HELLO";//s1,s2 is referring same address in String constant pool
//		String s2="HELLO";
//		String s3=new String("HELLO");
//		System.out.println(s1==s2);//true->compare values and address
//		System.out.println(s1==s3);//false->
//		System.out.println(s1.equals(s2));//true->content comparison
//		System.out.println(s1.equals(s3));//true->
		
		System.out.println("============================================");
		System.gc();
		//performance or speed test
		long start= new GregorianCalendar().getTimeInMillis();
		long startMemory=Runtime.getRuntime().freeMemory();
		String str=new String();
		//StringBuilder str=new StringBuilder();
		//StringBuffer str=new StringBuffer();
		for(int i=0;i<100000;i++) {
			str.concat("i:");
		}
		long end= new GregorianCalendar().getTimeInMillis();
		long endMemory=Runtime.getRuntime().freeMemory();
		System.out.println("Time taken:"+(end-start));
		System.out.println("Memory used:"+(endMemory-startMemory));
	}

}
