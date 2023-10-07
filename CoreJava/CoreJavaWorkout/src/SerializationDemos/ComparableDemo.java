package SerializationDemos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		List<Candidate> students = new ArrayList<Candidate>();

		students.add(new Candidate(101, "vasu", "java", 70));
		students.add(new Candidate(102, "ram", "php", 90));
		students.add(new Candidate(103, "karan", "python", 80));
		students.add(new Candidate(104, "arun", "python", 70));
		//Collections.sort(students);
		//Collections.sort(students,Collections.reverseOrder());
//		for(Candidate candidate:students)
//			System.out.println(candidate);
		Candidate student=Collections.min(students);
		Candidate student2=Collections.max(students);
		
		System.out.println("min marks"+student);
		System.out.println("max marks"+student2);
		students.clear();
	}

}
class Candidate implements Comparable<Candidate>{
	int stid;
	String name;
	String course;
	int marks;

	public Candidate(int stid, String name, String course, int marks) {
		super();
		this.stid = stid;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}

	@Override
	public String toString() {

		return "Stid:" + stid + ", stdname:" + name + ", Course:" + course + ", marks:" + marks;
	}

	@Override
	public int compareTo(Candidate o) {
//		if(this.marks==o.marks)
//		return 0;
//		else if(this.marks>o.marks)
//			return 1;
//		else
//			return -1;
		return this.marks-o.marks; //for min max marks object
		
	}

}
