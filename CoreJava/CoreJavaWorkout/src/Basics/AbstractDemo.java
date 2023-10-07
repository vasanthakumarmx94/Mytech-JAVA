package Basics;

public class AbstractDemo {

	public static void main(String[] args) {
		
		Collage1 child=new Collage1();
		child.InfoTech();
		child.sports();

	}

}
abstract class University{
	void InfoTech() {
		System.out.println("IT");
	}
	abstract void sports();//without body
}

class Collage1 extends University{

	@Override
	void sports() {
		
		System.out.println("Collage1 sport:Cricket");
	}
	
}


class Collage2 extends University{

	@Override
	void sports() {
		
		System.out.println("Collage1 sport:footbal");
	}
}