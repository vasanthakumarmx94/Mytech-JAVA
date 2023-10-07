package SerializationDemos;

import java.util.Arrays;

public class ShallowDeepCloneTest {

	public static void main(String[] args) {
		
		int[] a= {10,20,30,40};//original object
		Shallow s=new Shallow(a);
		s.showData();
		a[0]=100;//changed but having same reference
		s.showData();
		System.out.println("===============");
		//System.out.println(s.hashCode());
		System.out.println(a.hashCode());
		System.out.println("===================");
		Deep d=new Deep(a);
		d.showData();
		a[0]=500;
		d.showData();	
	}
}

//shallow copy:copy of reference to objects
class Shallow{
	private int[]data;//having same reference
	
	public Shallow(int[]data1) {
		data=data1;//having same reference
	}
	public void showData() {
		System.out.println(Arrays.toString(data));
		System.out.println(data.hashCode());
	}
}
class Deep{
private int[]data;//having same reference
	
	public Deep(int[]data1) {
		data=new int[data1.length];//object creation
		for(int i=0;i<data.length;i++) {
			data[i]=data1[i];
		}
	}
	public void showData() {
		System.out.println(Arrays.toString(data));
		
	}
}