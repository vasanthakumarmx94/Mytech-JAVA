import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHasMap;
import java.util.stream.Collectors;  

public class DepoWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "maharashtra";
		int len = str.length();
		// -------------------------------------
//		int counter[]=new int[256];
//		
//		for(int i=0;i<len;i++) {
//			counter[(int)str.charAt(i)]++;
//		}
//		for(int i=0;i<256;i++) {
//			if(counter[i]!=0) {
//				System.out.println((char) i+"-->"+counter[i]);
//			}
//		}

		
		//---------------------------------------
		
		HashMap<Character, Integer> chcount = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			if(chcount.containsKey(str.charAt(i))) {
				int count =chcount.get(str.charAt(i));
				chcount.put(str.charAt(i),++count);
				
			}else {
				chcount.put(str.charAt(i),1);
			}
			
			
		}
		System.out.println(chcount);
//----------------------------------------------------------------
		
//		String str1= "Communication";  
//		Map<String, Long> result = Arrays.stream(str.split(""))
//				.map(String::toLowerCase)
//				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));  
//		System.out.println(result);  
		
		
		
	}

}
