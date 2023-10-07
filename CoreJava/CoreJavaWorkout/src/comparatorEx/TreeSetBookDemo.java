package comparatorEx;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetBookDemo {

	public static void main(String[] args) {

		Book b1=new Book(121,"java reference",600.00,"karan");
		Book b2=new Book(144,"php",800.00,"haran");
		Book b3=new Book(131,"c#",500.00,"praveen");
		Book b4=new Book(122,"python",900.00,"jeevan");
		Book b5=new Book(121,"java reference",600.00,"karan");
		
		Comparator<Book> compare=null;
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			compare=new CompareById();
			break;
		case 2:
			compare=new CompareByName();
			break;
		case 3:
			compare=new CompareByprice();
			break;
		case 4:
			compare=new ComparebyAuthor();
			break;
		default:
			System.out.println("Enter valid choice");
		}
		
		Set<Book> bookset=new TreeSet<Book>(compare);
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
