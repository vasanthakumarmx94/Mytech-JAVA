
public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 5, 6, 0, 4, 6, 0, 9, 0, 8 };
        int n = A.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                swap(A, i, j); // Partitioning the array
            
//                if(A[i]>A[j+1]) {
//                	int temp =A[i];
//                	A[i]=A[j+1];
//                	A[j+1]=temp;
//                }
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " "); // Print the array
        }
	}
	 public static void swap(int[] A, int a, int b)
	    {
	        int temp = A[a];
	        A[a] = A[b];
	        A[b] = temp;
	    }

}
