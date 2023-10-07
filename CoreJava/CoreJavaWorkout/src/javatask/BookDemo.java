package javatask;

import java.util.*;

public class BookDemo {

	static List<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {

		// System.out.println();
		int book_id;
		String b_name;
		int b_price;
		//String b_auth[];
		int choice;
		Scanner sc = new Scanner(System.in);
		outer: while (true) {
			System.out.println("\n--------------------------------------------");
			System.out.println("1. Add New book in arraylist ");
			System.out.println("2. Search any Book on the basis of book Id ");
			System.out.println("3. Search any Book on the basis of name ");
			System.out.println("4. Search any book on the basis of author");
			System.out.println("5. Delete any book by using book id ");
			System.out.println("6. Display whole arraylist using ListIterator");
			System.out.println("--------------------------------------------\n");

			// Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("===============================");
				System.out.println("ADD NEW BOOK");
				System.out.println("===============================");
				System.out.print("Enter Book Id:");
				book_id = sc.nextInt();
				System.out.print("Enter Book Name:");
				b_name = sc.next();
				System.out.print("Enter Book price:");
				b_price = sc.nextInt();
				System.out.println("Enter How many number of authers you want to add:");
				int nauth = sc.nextInt();
				String authn[] = new String[nauth];
				System.out.println("Enter " + nauth + " auther names");
				for (int i = 0; i < nauth; i++) {
					authn[i] = sc.next();
				}
				String authnames = Arrays.toString(authn);
				Book b = new Book();
				b.bookid = book_id;
				b.bname = b_name;
				b.price = b_price;
				b.authn = authnames;
				boolean bl = bookList.add(b);
				if (bl == true) {
					System.out.println("Book Add Sucessfully");
				}
				break;
			case 2:
				System.out.println("===============================");
				System.out.println("SEARCH ANY BOOK ON BASIS OF BOOKID");
				System.out.println("===============================");
				System.out.print("Enter BOOKID to Search:");
				int bookid=sc.nextInt();
				for (Book books : bookList) {
					if(books.bookid==bookid) {
						System.out.println(books);
					}
				}
				break;
			case 3:
				System.out.println("===============================");
				System.out.println("SEARCH ANY BOOK ON BASIS BOOKNAME");
				System.out.println("===============================");
				System.out.print("Enter BOOKNAME to search:");
				String bookname=sc.next();
				for (Book books : bookList) {
					String book=books.toString();
					if(book.contains(bookname)) {
						System.out.println(books);
					}
				}
				
				break;
			case 4:
				System.out.println("===============================");
				System.out.println("SEARCH ANY BOOK ON BASIS AUTHOR");
				System.out.println("===============================");
				System.out.print("Enter AUTHORNAME to search:");
				String authorname=sc.next();
				for (Book books : bookList) {
					String book=books.authn;
					if(book.contains(authorname)) {
						System.out.println(books);
					}
				}
				
				break;
			case 5:
				System.out.println("===============================");
				System.out.println("DELETE ANY BOOK BY USING BOOKID");
				System.out.println("===============================");
				System.out.print("Enter BOOKID to DELETE:");
				int bkid=sc.nextInt();
				for (Book books : bookList) {
					if(books.bookid==bkid) {
						bookList.remove(books);
					}
				}
				System.out.println("Deleted Sucessfully");
				break;
			case 6:
				System.out.println("===============================");
				System.out.println("DISPLAY WHOLE ARRAYLIST USING LISTITERATOR");
				System.out.println("===============================");
				ListIterator<Book> litr = bookList.listIterator();
				while(litr.hasNext()){
					System.out.println(litr.next());
				}
				break;
			default: 
				System.err.println("Please Enter valid choice");

			}

		}

	}

}
