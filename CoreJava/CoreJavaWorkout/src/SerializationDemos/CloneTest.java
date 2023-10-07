package SerializationDemos;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		IPhone13 iphone13=new IPhone13(12,5.2,3.5);
		IPhone13 iphone13_1=(IPhone13)iphone13.clone();
		IPhone13 iphone13_2=(IPhone13)iphone13.clone();
		IPhone13 iphone13_3=(IPhone13)iphone13.clone();
		IPhone13 iphone13_4=(IPhone13)iphone13.clone();
		IPhone13 iphone13_5=(IPhone13)iphone13.clone();
		iphone13_4.height=6.2;	//it can change
		System.out.println(iphone13_4.height);
		System.out.println(iphone13_5.height+" "+iphone13_5.weight);
		
	}

}

class IPhone13 implements Cloneable{
	double weight;
	double height;
	double width;
	public IPhone13(double weight, double height, double width) {
		super();
		this.weight = weight;
		this.height = height;
		this.width = width;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
}