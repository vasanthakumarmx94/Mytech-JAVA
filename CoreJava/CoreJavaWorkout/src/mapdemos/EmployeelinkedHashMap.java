package mapdemos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class EmployeelinkedHashMap {

	public static void main(String[] args) {

		Map<String, Integer> dictionary = new LinkedHashMap<String, Integer>();

		dictionary.put("101", 10000);
		dictionary.put("104", 20000);
		dictionary.put("102", 50000);

		dictionary.put("106", 30000);
		// duplicates values allowed
		dictionary.put(null, null);
		dictionary.put(null, 2000);// single null key allowed
		dictionary.put("108", null);// multiple null values allowed
		dictionary.put("107", null);
		dictionary.put("109", 2000);
		System.out.println(dictionary);
		System.out.println("find element from LinkedHashMap:-------");
		int salary = dictionary.get("102");
		// System.out.println();
		if (salary >= 0) {
			System.out.println(salary);
		}
		System.out.println("removing element from Map:-------");
		// int mean=dictionary.remove("108");
		System.out.println(dictionary.remove("107"));
		System.out.println(dictionary);
		System.out.println("----------keys-----------");
		Set<String> st = dictionary.keySet();
		System.out.println(st);
		System.out.println("----------values-----------");
		Collection<Integer> col = dictionary.values();
		System.out.println(col);
		System.out.println("Using iterator------------");
		Iterator<Entry<String, Integer>> itr = dictionary.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			System.out.println(entry);
		}
		System.out.println("--replace value of 102 key");
		dictionary.replace("102",50000, 800000);
		System.out.println(dictionary);
	}

}
