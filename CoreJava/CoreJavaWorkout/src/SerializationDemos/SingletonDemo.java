package SerializationDemos;



public class SingletonDemo {

	public static void main(String[] args) {
		
		//initialize singleton class
		Singleton obj1=Singleton.getInstance();
		
		//initialize singleton class
		Singleton obj2=Singleton.getInstance();
		System.out.println("Hashcode of obj1:"+obj1.hashCode());
		System.out.println("Hashcode of obj2:"+obj2.hashCode());
		System.out.println("dbName:"+obj1.database_name);
	}

}
class Singleton{
	private static Singleton single_obj=null;
	
	//member
	public String database_name;
	//private constructor
	private Singleton() {
		database_name="My_database";
		
	}
	public static Singleton getInstance() {
		
		if(single_obj==null)
			single_obj=new Singleton();
		return single_obj;
		
		
	}
	
}