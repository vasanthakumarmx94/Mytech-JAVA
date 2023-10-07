
public class ThreadExample implements Runnable {

//	public void run() 
//		System.out.println("thread is running...");  
//		}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadExample th=new ThreadExample();
		
		Thread t = new Thread(th,"fist");

		// the start() method moves the thread to the active state
		t.start();
		// getting the thread name by invoking the getName() method
		String str = t.getName();
		System.out.println(str);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("started Thread");
	}

}
