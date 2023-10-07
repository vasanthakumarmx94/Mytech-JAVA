package setdemos;

import java.util.LinkedHashSet;
import java.util.Set;

public class linkedHashset {

	public static void main(String[] args) {

		Set<String> nameset=new LinkedHashSet<>();
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

	}

}
