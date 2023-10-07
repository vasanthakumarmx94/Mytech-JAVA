package Java8Features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpression2Demo {

	public static void main(String[] args) {

//		Runnable runable=()->{
//			for(int i=0;i<10;i++) {
//				try {
//					System.out.print(i+" ");
//					Thread.sleep(500);
//				}catch(Exception e) {
//					System.out.println(e);
//				}
//			}
//		};
//		new Thread(runable).start();

//		List<Integer> list = new ArrayList<Integer>();
//		list.add(20);
//		list.add(10);
//		list.add(60);
//		list.add(50);
//		list.add(40);
//		list.forEach((number) -> {
//			if (number < 40)
//				System.out.print(number + " ");
//		});
//		list.clear();
		List<Mobile> mobiles=new ArrayList<Mobile>();
		mobiles.add(new Mobile(1,"vivo",10000));
		mobiles.add(new Mobile(2,"redme",15000));
		mobiles.add(new Mobile(3,"samsung",20000));
		mobiles.add(new Mobile(4,"Apple",80000));
		
		Collections.sort(mobiles, (k1,k2)->k1.name.compareTo(k2.name));
		mobiles.forEach((mobile)->System.out.println(mobile.name));
		mobiles.clear();
		
	}

}

class Mobile {
	int id;
	String name;
	double price;

	public Mobile(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
