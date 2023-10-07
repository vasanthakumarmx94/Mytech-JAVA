import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DEMoTask {

	public static void main(String[] args) {

		int[] a = { 6,2,2,8,5,9};
		//int[] a = { 1,2,4};
		
		
		int count = 0;

		Arrays.sort(a);
//		for(int m:a) {
//			System.out.println(m);
//		}
		
		//System.out.println(a[a.length-1]);
		for (int i = a[0]; i < a[a.length-1] ; i++) {
				int f=0;
				for(int j=0;j<a.length-1;j++) {
					if(a[j]==i) {
						
						f=1;
						break;
					}
					
				}
				if(f==0) {
					count++;
				}
				
			

		}
		System.out.println("Count:"+count);

	}

}
