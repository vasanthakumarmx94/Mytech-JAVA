package Basics;
import java.lang.*;//default package
public class InheritanceTest {
	public static void main(String args[]) {
		child child=new child();
		child.showChild();
		
		
		parent object=new parent();
		object.showParent();
		object.parent_member1=100;
		
		Child2 c1=new Child2();
		
		
		
	}

}

class parent {
	int parent_member1;

	void showParent() {
		System.out.println("Im for parents,");

	}
}

class child extends parent {
	int child_member1;

	void showChild() {
		System.out.println("Im for Child,");

	}

}

class Child2 extends child {
	int child2_member;
}

////super Keyword
class A {
	String name;

	void show() {
		System.out.println(name);
	}

}

class B extends A {
	String name;

	void show() {
		super.show();
		name = "B";
		System.out.println(name);
	}

}
