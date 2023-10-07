package Java8Features;

import java.util.Arrays;

public class paraalelArraySort {

	public static void main(String[] args) {
		
		int numbers[]= {22,10,25,22,21,23,0,1,2,9,99,5,56,36,65};
		Arrays.parallelSort(numbers);
		
		Arrays.stream(numbers).forEach(n->System.out.print(n+" "));
		
		System.out.println("\n----------------");
		int numbers2[]= {22,10,25,22,21,23,0,1,2,9,99,5,56,36};
		Arrays.parallelSort(numbers2,2,10);//9-2->position elements sorted
		Arrays.stream(numbers2).forEach(n->System.out.print(n+" "));
		
	}

}
