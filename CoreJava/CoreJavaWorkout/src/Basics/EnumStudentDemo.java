package Basics;

import java.util.Scanner;

class Studentm {
	int stid;
	String stname;
	Subject s;
	int marks;
	public Studentm(int stid, String stname, Subject s, int marks) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.s = s;
		this.marks = marks;
	}

}

public class EnumStudentDemo {

	public static void main(String[] args) {
		Studentm s1 = new Studentm(11, "vasu", Subject.JAVA, 600);
		Studentm s2 = new Studentm(12, "praveen", Subject.CPP, 500);
		Studentm s3 = new Studentm(13, "Karan", Subject.C, 400);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter subject to disply student:");
		Studentm sm[]= {s1,s2,s3};
				String sub = sc.next().toUpperCase();
	
		for(Studentm std:sm) {
			if(std.s.valueOf(sub).equals(sub))
			{
				System.out.println("sname:"+std.stname+"subject :"+std.s);
			}
		}
	

	}

}
