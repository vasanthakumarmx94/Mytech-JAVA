package setdemos;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetBookDemo {

	public static void main(String[] args) {

		Book b1=new Book(121,"java reference",600.00,"karan");
		Book b2=new Book(144,"php",800.00,"haran");
		Book b3=new Book(131,"c#",500.00,"praveen");
		Book b4=new Book(122,"python",900.00,"jeevan");
		Book b5=new Book(121,"java reference",600.00,"karan");
		
		Set<Book> bookset=new TreeSet<Book>();
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
