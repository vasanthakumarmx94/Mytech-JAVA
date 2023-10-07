package javatask;

class Book {
	int bookid;
	String bname;
	int price;
	String authn;

	public Book(int book_id, String b_name, int b_price, String authn[]) {

	}
	
	public Book() {
		
	}

	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getName() {
		return bname;
	}

	public void setName(String bname) {
		this.bname = bname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuth() {
		return authn;
	}

	public void setAuth(String auth) {
		this.authn = auth;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bookid:"+bookid+", BookName:"+bname+" ,BookPrice:"+price+" ,Authors:"+authn;
	}

}
