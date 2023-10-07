package Java8Features;

interface Showable {
	void show();
}

interface Showable2 {
	void show2(String msg);
}

public class MethodReferencing {

//	public MethodReferencing() {
//		//System.out.println(msg);
//	}

	public static void showtext() {
		System.out.println("Im static methods");
	}

	public void showText2() {// instance method
		System.out.println("Im instance meythod");
	}

	public static void main(String[] args) {
		
		//refer static method 
		Showable s=MethodReferencing::showtext;//static method referencing
		s.show();
		//new Thread(MethodReferencing::showtext().start();
		

		
//		System.out.println("-----------------");
//		MethodReferencing obj=new MethodReferencing();
//		Showable s2=obj::showText2;//instance method referencing
//		s2.show();
//		new Thread(new MethodReferencing()::showText().start(); 
	
		System.out.println("------------------");
		//Showable2 s3=MethodReferencing::new;     //constructor referencing
		//equelent to  Showable2 s3=(msg)->{System.out.println(msg);}
		//s3.show2("welcome");
	}

}
