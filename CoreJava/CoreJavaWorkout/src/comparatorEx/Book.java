package comparatorEx;

public class Book {

	private int bookid;
	private String bookname;
	double price;
	private String author;
	
	public Book(int bookid, String bookname, double price, String author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "bookId:"+bookid+" ,BookName:"+bookname+" ,Book prce:"+price+" ,Bookauthor:"+author;
	}
	
	
	
	
	
}
