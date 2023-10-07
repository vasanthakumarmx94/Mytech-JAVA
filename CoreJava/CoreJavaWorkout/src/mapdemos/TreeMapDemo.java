package mapdemos;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Map<String, String> dictionary = new TreeMap<String, String>();

		dictionary.put("diamand", "a precious stone consisting of a clear and colourless crystalline form of pure carbon");
		dictionary.put("sun", "the light or warm received from the earth");
		dictionary.put("sun", "thae stars are there");
		
		dictionary.put("pushkar diamand", "a precious stone consisting of a clear and colourless crystalline form of pure carbon");
		//duplicates values allowed
		//dictionary.put(null, null);
		//dictionary.put(null, "ABCD");//single null key allowed
		dictionary.put("waitage", null);//multiple null values allowed
		dictionary.put("upload", null);
		dictionary.put("cow", "a fully grown female animal of a domesticated breed of ox, kept to produce milk or beef.");
		System.out.println(dictionary);
		
		
	}

}
