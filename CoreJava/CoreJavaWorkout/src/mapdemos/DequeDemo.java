package mapdemos;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Ravi");
		deque.add("Vijay");
		deque.add("Ajay");
		deque.addFirst("keer");
		deque.addLast("vasu");
		System.out.println(deque);
		System.out.println("Remove first:--------------------");
		deque.removeFirst();
		System.out.println(deque);
		
		System.out.println("Remove Last:--------------------");
		deque.removeLast();
		System.out.println(deque);
		
		//System.out.println(deque);
		System.out.println("--------------------------------------");
		deque.offer("arvind");
		deque.offer("vimal");
		deque.add("mukul");
		deque.offerFirst("jai");
		System.out.println(deque);
		
		 //deque.poll();
		// deque.pollFirst();//it is same as poll()
		deque.pollLast();
		System.out.println("After pollLast() Traversal...");
		System.out.println(deque);
		System.out.println("Using enhance for");
		for (String s : deque) {
			System.out.println(s);
		}
	}
}
