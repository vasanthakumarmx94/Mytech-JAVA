package SerializationDemos;

public class GenericsTest {

	public static void main(String[] args) {
		
		TestGen1<Integer> intObj=new TestGen1<Integer>(100);
		System.out.println(intObj.getObject());
		
		TestGen1<String> strObj=new TestGen1<String>("Java");
		System.out.println(strObj.getObject());

		System.out.println("--------------------------");
		
		TestGen2<String,Integer> strIntObj=new TestGen2<String,Integer>("java",8);
		System.out.println(strIntObj);
		TestGen2<Integer,Double> IntDbObj=new TestGen2<Integer,Double>(8,1.8);
		System.out.println(IntDbObj);
		
		System.out.println("--------------------");
		TestGen3.genericMethod(8);	
		TestGen3.genericMethod("Python");	
		TestGen3.genericMethod(8.56);
		TestGen3.genericMethod(1.6f);	
		
	}

}
//<>to specify parameter type

class TestGen1<T>{
	T obj;
	public TestGen1(T obj) {
		this.obj=obj;
		
	}
	public T getObject() {
		return this.obj;
		
	}
}

class TestGen2<T,U>{
	T obj1;
	U Obj2;
	public TestGen2(T obj1,U obj2) {
		this.obj1=obj1;
		this.Obj2=obj2;
		
	}
	@Override
	public String toString() {
		return this.obj1+", "+this.Obj2;
	}
	
}

class TestGen3{
	static <T> void genericMethod(T element) {
		System.out.println(element.getClass().getName()+"="+element);
		
	}
}