
public class Task {

	public static void main(String[] args) {
		//secondLargest 
		int[] a= {4,2,5,6};
		int largest=0;int second=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>largest) {
				second=largest;
				largest=a[i];
			}else if(a[i]>second) {
				largest=a[i];
			}
		}
		
		System.out.println(second);

	}

}
