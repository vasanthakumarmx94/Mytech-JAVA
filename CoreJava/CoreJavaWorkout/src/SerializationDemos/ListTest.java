package SerializationDemos;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student(101, "vasu", "java", 70));
		students.add(new Student(102, "ram", "php", 90));
		students.add(new Student(103, "karan", "python", 80));

		Iterator<Student> itr = students.iterator();
		while (itr.hasNext()) {
			Student student = itr.next();
			System.out.println(student);

		}
		students.remove(2);
		students.add(1, new Student(100, "pavan", "java", 80));

		students.add(new Student(105, "veeru", "c#", 70));

		System.out.println("======================");
		for(Student student:students)
		{
			//int i=0;
		
//			System.out.println(student.getClass());
//			Object stid;
//			if(stid.getClass()==Integer) {
//			
//		}
			
		}
		
		
		System.out.println("---------------------------");
		
		ArrayList<Student> newstudent=new ArrayList<Student>();
		for(Student student:newstudent) {
			if(student.marks>80)
				new Student(student.stid,student.name,student.course,student.marks);
		}
		
		
		for (Student student : newstudent) {
			System.out.println(student);
			// System.out.println(student.course);
		}

		newstudent.clear();
		ArrayList<Object> complexList=new ArrayList<Object>(Arrays.asList(null,"abc",100,10.5,true));
		for(Object obj:complexList)
			System.out.println(obj);
	
		complexList.addAll(Arrays.asList(10f,"java",90,30,40));
		for(Object obj:complexList)
			System.out.println(obj);
		complexList.clear();
//		int sum;
//		for(Object obj:complexList)
//		{
//			if(obj.getClass()==java.lang.Integer) {
//				sum=sum+(int)obj;
//			}
//		}
		
		//display sum if integers numbers from collection
		
		//Linked list 
		//head -->prev | Next-->prev  | Next-->Null
		System.out.println("-----------------------------");
		LinkedList<Object> complexlinkedList=new LinkedList<Object>
		(Arrays.asList(null,"abc",100,10.5,true));
		complexlinkedList.add(2,"java");
		complexlinkedList.addFirst(1.8);
		System.out.println("removed:"+complexlinkedList.removeLast());
		
		for(Object obj:complexlinkedList)
			System.out.println(obj);
		
		complexlinkedList.clear();
	}

}

class Student {
	int stid;
	String name;
	String course;
	int marks;

	public Student(int stid, String name, String course, int marks) {
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

}
