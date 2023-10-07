package Java8Features;

import java.util.Optional;

public class OptionalclassDemo {

	public static void main(String[] args) {
		
		String[] str=new String[5];
		//System.out.println(str[3].toLowerCase());//this is null pointer exception
		str[2]="welldone";
		Optional<String> checkNull=Optional.ofNullable(str[2]);
		//lambda expression
		Optional.ofNullable(str[2]).ifPresent(s->System.out.println(s.toUpperCase()));
//		if(checkNull.isPresent())
//			System.out.println(str[2].length());
//		else
//			System.out.println("value not present");
//	
//		
		
		
	}

}
