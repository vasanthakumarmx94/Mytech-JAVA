package setdemos;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetBookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book b1=new Book(121,"java reference",600.00,"karan");
		Book b2=new Book(144,"php",800.00,"haran");
		Book b3=new Book(131,"c#",500.00,"praveen");
		Book b4=new Book(122,"python",900.00,"jeevan");
		Book b5=new Book(121,"java reference",600.00,"karan");
		
		Set<Book> bookset=new LinkedHashSet<Book>();
		bookset.add(b1);
		bookset.add(b2);
		bookset.add(b3);
		bookset.add(b4);
		bookset.add(b5);
		for(Book book:bookset) {
			System.out.println(book);
		}
		
	}

}
