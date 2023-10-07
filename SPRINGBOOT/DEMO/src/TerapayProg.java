import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TerapayProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer a[] = new Integer[] { 1, 2, 4 };
		List<Integer> list = Arrays.asList(a);

		System.out.println(list);
		
//		IntSummaryStatistics stats = list.stream()
//			      .collect(Collectors.summarizingInt(Integer::intValue));
//
//			int min = stats.getMin();
//			int max = stats.getMax();

		Integer maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();

		Integer minNumber = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

		// minNumber1 = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

		list.stream().forEach((el) -> {
			int count = 0;
			int f = 0;
			for (int i = minNumber; i < maxNumber; i++) {
				if (el == i) {
					f = 1;
					continue;
				}

			}
			if (f == 0) {
				count++;
			}
			System.out.println(count);
		});

	}

}
