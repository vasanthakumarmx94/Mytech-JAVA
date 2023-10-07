package Basics;

public class AccessSpecifierTest {
	//default member
	int default_member=10;
	//default method
	void defaultshow() {
		System.out.println("Default show!");
	}
	//public member
	public int public_member=20;
	//public method
	public void publicshow() {
		System.out.println("public show!");
	}

	//protected member
	protected int protected_member=30;
	//protected method
	protected void protectedshow() {
		System.out.println("protected show!");
	}
	//private member
	private int private_member=40;
	//private method
	private void privateshow() {
		System.out.println("private show!");
	}
public static void main(String a[]) {
	AccessSpecifierTest obj=new AccessSpecifierTest();
	ChildTest cobj=new ChildTest();
	cobj.default_member=700;
	cobj.protected_member=800;
	
}


}
class ChildTest extends AccessSpecifierTest{
	
}

class NonSubClass{
	public void show() {
		new AccessSpecifierTest().default_member=500;
	}
}
