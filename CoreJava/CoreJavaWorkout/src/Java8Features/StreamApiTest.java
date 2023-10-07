package Java8Features;

import java.util.stream.Stream;

public class StreamApiTest {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("A$B$C".split("\\$"));
		stream.forEach(p -> System.out.println(p));
		
		
	}
	
}
