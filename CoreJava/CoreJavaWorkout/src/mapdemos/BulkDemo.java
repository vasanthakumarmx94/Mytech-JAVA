package mapdemos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BulkDemo {

	public static void main(String[] args) {
		

		Integer arr1[]= {45,23,8,56,23,77,56};
		List<Integer> list1=Arrays.asList(arr1);//immutable array list
		System.out.println(list1.getClass());
		System.out.println(list1);
		
		List<Integer> list2=Arrays.asList(23,12,90,45,87);//immutable array list
		System.out.println(list2);
		
		
		List<Integer> list3=new ArrayList<Integer>();
		list3.add(30);list3.add(20);list3.add(60);list3.add(40);
		list3.add(10);list3.add(90);
		System.out.println("list3:"+list3);
		
		List<Integer> list4=new ArrayList<Integer>();
		list4.add(60);list4.add(70);list4.add(40);list4.add(15);
		list4.add(10);list4.add(90);
		System.out.println("list4:"+list4);
		
		List<Integer> list5=new ArrayList<Integer>();
		list5.add(10);list5.add(90);
		System.out.println("list5:"+list5);
		
		//list3.addAll(list4);// add all element of list4 to list 3
		//list3.retainAll(list4);//elements which are common in both list3
		//list3.removeAll(list4);// opposite to retainall,this remove common element of both and display list3 remain in elements
		
		//list4.removeAll(list3);
		boolean b=list3.containsAll(list5);
		System.out.println(b);
		System.out.println("list3:"+list4);
		
		
		//copy content of one array list to another ayyalist:addall
		
		
		//keep common objects:
		//check where one array list elements area available are not
	}

}
