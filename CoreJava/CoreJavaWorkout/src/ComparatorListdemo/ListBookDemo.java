package ComparatorListdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import comparatorEx.Book;
import comparatorEx.CompareById;
import comparatorEx.CompareByName;
import comparatorEx.CompareByprice;
import comparatorEx.ComparebyAuthor;

public class ListBookDemo {

	public static void main(String[] args) {

		Book b1=new Book(121,"java reference",600.00,"karan");
		Book b2=new Book(144,"php",800.00,"haran");
		Book b3=new Book(131,"c#",500.00,"praveen");
		Book b4=new Book(122,"python",900.00,"jeevan");
		Book b5=new Book(121,"java reference",600.00,"karan");
		List<Book> booklist=new ArrayList<Book>();
		booklist.add(b1);
		booklist.add(b2);
		booklist.add(b3);
		booklist.add(b4);
		booklist.add(b5);
		for(Book book:booklist) {
			System.out.println(book);
		}
		
		Comparator<Book> compare=null;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Choice:");
		System.out.println("1.compareById");
		System.out.println("2.CompareByName");
		System.out.println("3.CompareByprice");
		System.out.println("4.ComparebyAuthor");
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
		Collections.sort(booklist,compare);
		for(Book book:booklist) {
			System.out.println(book);
		}
		
	}

}
