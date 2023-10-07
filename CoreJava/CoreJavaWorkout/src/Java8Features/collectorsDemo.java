package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class collectorsDemo {

	public static void main(String[] args) {
		
		List<Integer> listint=new ArrayList<Integer>(Arrays.asList(10,30,20,40,60));
		
		Set<Integer> setint=listint.stream().filter(i->i>20).collect(Collectors.toSet());
		System.out.println(setint);
		long counter=listint.stream().collect(Collectors.counting());
		System.out.println("count:"+counter);
		//int total=listint.stream().collect(Collectors.summarizingInt(null));
		setint.clear();
		listint.clear();
		
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,90));
		students.add(new Student(2,70));
		students.add(new Student(3,90));
		students.add(new Student(6,80));
		students.add(new Student(5,70));
		int totalmark=students.stream().collect(Collectors.summingInt(st->st.marks));
		System.out.println(totalmark);
				
		double avgmark=students.stream().collect(Collectors.averagingInt(st->st.marks));
		System.out.println(avgmark);
				
		System.out.println(students.stream().collect(Collectors.groupingBy(st->st.marks)));
		System.out.println(students.stream().collect(Collectors.groupingBy(st->st.marks,Collectors.counting())));
		System.out.println(students.stream().collect(Collectors.summarizingInt(st->st.marks)));
		
	}

}

class Student{
	int id;
	int marks;
	public Student(int id, int marks) {
		super();
		this.id = id;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "id=" + id + ", marks=" + marks + "";
	}
	
	
}