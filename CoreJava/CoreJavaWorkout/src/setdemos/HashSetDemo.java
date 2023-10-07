package setdemos;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;
import java.util.Set;

public class HashSetDemo {
	//store employee names in hashset
	
public static void main(String[] args) {
	
	Set<String> nameset=new HashSet<>();
	System.out.println(nameset);
	nameset.add("vasu");
	nameset.add("karan");
	nameset.add("vasu");
	nameset.add("Bhuvan");
	nameset.add("Ragu");
	System.out.println(nameset);
	//enhanced for loop
	for(String name:nameset) {
		System.out.println(name);
	}
	//for each
	System.out.println("foreach----------------");
	nameset.forEach(nm->System.out.println(nm));
	
	//using iterator
	Iterator<String> itr=nameset.iterator();
	while(itr.hasNext()) {
		String name=itr.next();
		System.out.println(name);
		if(name.equals("vasu")) {
			itr.remove();
		}
	}
	System.out.println(nameset);
	
	
	
	System.out.println("----------------------");
	List<String> namelist=new ArrayList<>();
	namelist.add("praveen");
	namelist.add("gani");
	namelist.add("raj");
	namelist.add("param");
	namelist.add("raj");
	System.out.println("List iterator");
	ListIterator<String> litr=namelist.listIterator();
	while(litr.hasNext()) {
		String name=litr.next();
		System.out.println(name);
		int ind=litr.nextIndex();
		if(ind==3) {
			litr.add("bharath");
		}
	}
	System.out.println(	namelist);
	
	
}

}
