package Basics;

public class HasATest {
	public static void main(String args[]) {
		Author sachin = new Author("Sachin",35,"Pune");
		Author rohan = new Author("Rohan",30,"Mumbai");
		
		Publisher himalaya = new Publisher("Himalaya", "Noida");
		Publisher vision = new Publisher("vision", "Pune");
		
		Book javaBook = new Book("Java Basics", 100, sachin, himalaya);
		Book phpBook = new Book("Php Basics", 99, rohan, vision);
		Book springBook = new Book("Spring Basics", 199, sachin, vision);
		Book jspBook = new Book("Jsp Basics", 110, sachin, vision);
		
		Book[] library={javaBook,phpBook,springBook,jspBook};
		for(Book book:library) {
			if(book.publisher.pub_name.equalsIgnoreCase("vision")){
				System.out.println("Book Name:"+book.book_name);
				System.out.println("AuthorName:"+book.author.author_name);
			}
		}
	}
}
class Author{
	String author_name;
	int age;
	String place;
	public Author(String author_name, int age, String place){
		super();
		this.author_name = author_name;
		this.age = age;
		this.place = place;
	}
	
}
//relation with Author and Publisher (Has-a)
class Book{
	String book_name;
	double price;
	Author author;
	Publisher publisher;
	public Book(String book_name, double price, Author author, Publisher publisher) {
		super();
		this.book_name = book_name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	
}
class Publisher{
	
	String pub_name;
	String pub_city;
	public Publisher(String pub_name, String pub_city) {
		super();
		this.pub_name = pub_name;
		this.pub_city = pub_city;
	}
}
