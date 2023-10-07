package Java8Features;

import java.util.ArrayList;
import java.util.Date;

public class AnnotationDemo {

	@SuppressWarnings({"unchecked","rawtypes", "deprecation"})
	public static void main(String[] args) {
		
		ArrayList a=new ArrayList();
		a.add("xyz");
		System.out.println(new Date().getHours());
		new Check().show();
		
	}

}
class Check{
	@Deprecated //it may be removed in future versions
	void show() {
		System.out.println("show");
	}
}