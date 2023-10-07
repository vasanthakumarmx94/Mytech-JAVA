import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TP {

	public static void main(String[] args) {

		Integer a[] = new Integer[] { 1, 2, 4, 8, 2, 22, 11, 14 };
		List<Integer> listName = Arrays.asList(a);
		int large2 = listName.stream().sorted(Comparator.naturalOrder()).limit(3).skip(2).findFirst().get();
		System.out.println("");
		System.out.println("largest 2nd Number:" + large2);
		
		int large = listName.stream().sorted().limit(3).skip(2).findFirst().get();
		System.out.println("Largest number:"+large);

		List<Integer> mysortedlist = listName.stream().sorted().collect(Collectors.toList());
		System.out.println(mysortedlist);

		List<Integer> distlist = listName.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct:" + distlist);

		// ---------------------------------

		System.out.println("------------------------------------------");
		List<String> companies = new ArrayList<String>();

		// 1.1 add string elements to List
		companies.add("Meta");
		companies.add("Apple");
		companies.add("Amazon");
		companies.add("Netflix");
		companies.add("Meta"); // duplicate
		companies.add("Google");
		companies.add("Apple"); // duplicate
		Map<String, Integer> duplicateCountMap = companies.stream()
				.collect(Collectors.toMap(Function.identity(), company -> 1, Integer::sum));

		// 2.1 print Map for duplicate count
		System.out.println("\n2. Map with Key and its duplicate count : \n");
		duplicateCountMap.forEach((key, value) -> System.out.println("Key : " + key + "\t Count : " + value));

		System.out.println("------------------------------------------");
		// 4. get duplicate count using Map
		Map<String, Long> duplicateCount = companies.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		duplicateCount.forEach((key, value) -> System.out.println("Key : " + key + "\t Count : " + value));

		// -------------------------------

		String str1 = "veerancharacters";

		char[] charray = str1.toCharArray();
		List<char[]> listarray = Arrays.asList(charray);
		System.out.println("---------------------");
		listarray.forEach((al) -> {
			System.out.println(al);
		});

		Map<Character, Integer> duplicateCountMap3 = new HashMap<>();

		for (char ch : charray) {
			if (duplicateCountMap3.containsKey(ch)) {
				duplicateCountMap3.put(ch, duplicateCountMap3.get(ch) + 1);
			} else {
				duplicateCountMap3.put(ch, 1);
			}
		}
		System.out.println(duplicateCountMap3);

		List<Character> chars = str1.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

		System.out.println("-------------New--------");
		Map<Character, Integer> duplicateCountMap4 = chars.stream()
				.collect(Collectors.toMap(Function.identity(), company -> 1, Integer::sum));

		duplicateCountMap4.forEach((key, value) -> System.out.println("Key : " + key + "\t Count : " + value));

//        listarray.forEach(ch->duplicateCountMap3.merge( ch, 1, Integer::sum));
//        System.out.println(duplicateCountMap3);
//        //duplicateCountMap3.entrySet().forEach((k,v)->System.out.println("Key"+k+" Value"+v))
//        duplicateCountMap3.forEach(
//                (key, value) -> System.out.println("Key : " + key + "\t Count : " + value)
//                );
		// -------------------------------

		Map<String, Integer> duplicateCountMap2 = new HashMap<String, Integer>();
		// 2.1 iterate and store duplicate count into Map object
		companies.forEach(company -> duplicateCountMap2.merge(company, 1, Integer::sum));

		// 2.2 print to console
		System.out.println("\n2. Map with Key and its duplicate count : \n");
		System.out.println(duplicateCountMap2);

	}

}
