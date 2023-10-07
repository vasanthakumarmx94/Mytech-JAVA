package Basics;

public class Polymorphismtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate cal = new Calculate();
		cal.sum(10, 20);
		cal.sum(30, 40, 50);
		cal.sum(2.0f, 20);
		Polymorphismtest.main('V');
		
		
		System.out.println("=======================");
		 Dog dog=new Dog();
		 dog.eat();
		 
		 Animals an= new Dog();
		 an.eat();
		 

		System.out.println("=======================");
		Sample sample=new Sample(11.1,22.1);
		System.out.println(sample);
		

	}
	public static void main(char args) {
	System.out.println("Overloaded main:"+args);//main method overloaded
	}

}

class Calculate {
	void sum(int a, int b) {
		System.out.println("sum is:" + (a + b));
	}

	void sum(int a, int b, int c) {
		System.out.println("sum is:" + (a + b + c));
	}

	void sum(float a, int b) {
		System.out.println("sum is:" + (a + b));
	}

}
//Overriding

class Animals{
	public void eat() {
		System.out.println("Eat all eatbles");
	}
}
class Dog extends Animals{
	public void eat() {
		System.out.println("Eat meat...");
	}
	
}

class cat extends Animals{
	public void eat() {
		System.out.println("Drink milk");
	}
}

//override tostring

class Sample{
	private double a,b;

	public Sample(double a, double b) {
		//for ever class object is super class
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "A:"+a+", B:"+b;
	}

	

	
}



