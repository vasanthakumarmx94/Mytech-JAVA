package Java8Features;

//function interface
@FunctionalInterface
interface sample {
	public void show();
}
@FunctionalInterface
interface sample1 {
	public String show1(String msg);
}
@FunctionalInterface
interface addition {
	public int add(int num1,int num2);
}
@FunctionalInterface
interface addition1 {
	public int add(int num1,int num2,int num3);
}


public class LambdaExpressionDemo {

	public static void main(String[] args) {

		String str="Welcome"; 
		//with lambda expression
		sample s=()->{
			System.out.println("Message:"+str);
		};
		s.show();
		System.out.println("-------------------");
		sample1 s1=(msg)->{
			return msg;
		};
		System.out.println(s1.show1("Welcom java8"));
		
		System.out.println("-------------------");
		addition a=(n1,n2)-> n1+n2;
		System.out.println("Sum of two num:"+a.add(20, 30));
		System.out.println("-------------------");
		addition1 a1=(n1,n2,n3)->n1+n2+n3;
		System.out.println("Sum of 3 numbers:"+a1.add(10, 20, 30));
		System.out.println("-------------------");
		
		LambdaExpressionDemo obj=new LambdaExpressionDemo();
		//multiple implementation
		MathOperation add=(int m,int n)->m+n;
		MathOperation sub=(int m,int n)->m-n;
		MathOperation mul=(int m,int n)->m*n;
		MathOperation div=(int m,int n)->m/n;
		
		System.out.println("100+50="+obj.operate(100, 50, add));//add.operation(100,50);
		System.out.println("100-50="+obj.operate(100, 50, sub));
		System.out.println("100*50="+obj.operate(100, 50, mul));
		System.out.println("100/50="+obj.operate(100, 50, div));
		
	}
	//inside classs
	@FunctionalInterface
	interface MathOperation{
		int operation(int a,int b);
	}
	private int operate(int a,int b,MathOperation mathoperation) {
		return mathoperation.operation(a, b);
		
	}

}
