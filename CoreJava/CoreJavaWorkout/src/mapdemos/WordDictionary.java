package mapdemos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordDictionary {

	public static void main(String[] args) {

		Map<String, String> dictionary = new HashMap<String, String>();

		dictionary.put("diamand", "a precious stone consisting of a clear and colourless crystalline form of pure carbon");
		dictionary.put("sun", "the light or warm received from the earth");
		dictionary.put("sun", "thae stars are there");
		
		dictionary.put("pushkar diamand", "a precious stone consisting of a clear and colourless crystalline form of pure carbon");
		//duplicates values allowed
		dictionary.put(null, null);
		dictionary.put(null, "ABCD");//single null key allowed
		dictionary.put("waitage", null);//multiple null values allowed
		dictionary.put("upload", null);
		dictionary.put("cow", "a fully grown female animal of a domesticated breed of ox, kept to produce milk or beef.");
		System.out.println(dictionary);
		System.out.println("find element from Map:-------");
		String meaning=dictionary.get("cow");
		if(meaning==null)
			System.out.println("Word not found in dictinary");
		else
			System.out.println(meaning);
		System.out.println("removing element from Map:-------");
		String mean=dictionary.remove("cow");
		System.out.println(mean);
		
		System.out.println(dictionary);
		
		Set<String> keys=dictionary.keySet();
		System.out.println(keys);
		Collection<String> val=dictionary.values();
		System.out.println(val);
		System.out.println("--------------------------------");
		System.out.println("using iterator");
		
		Iterator<Entry<String,String>> itr=dictionary.entrySet().iterator();
		
		while(itr.hasNext()) {
			Entry<String,String> entry=itr.next();
			System.out.println(entry);
		}
		
	}

}
