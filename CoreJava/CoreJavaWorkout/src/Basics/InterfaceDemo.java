package Basics;

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vhi=new Vehicle();
		System.out.println(vhi.isMovable());
		System.out.println(vhi.isRollable());
		vhi.mov();
		

	}

}
interface Movable {
	int AVERAGE_SPEED=50;//auto->public ,final ,static
	void mov();//auto public and abstract
	boolean isMovable();
}
interface Rollable extends Movable{
	boolean isRollable();
}
class Vehicle extends InterfaceDemo implements Rollable{

	@Override
	public void mov() {
		System.out.println("Average speed is:"+AVERAGE_SPEED );
		
		
	}

	@Override
	public boolean isRollable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isMovable() {
		// TODO Auto-generated method stub
		return true;
	}
	
}