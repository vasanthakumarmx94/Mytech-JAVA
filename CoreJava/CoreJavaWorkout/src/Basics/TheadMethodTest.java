package Basics;

public class TheadMethodTest extends Thread {

	@Override
	public void run() {
		
	}

	public static void main(String[] args) {
//		Threadtest2 thread1=new Threadtest2();
//		Threadtest2 thread2=new Threadtest2();
//		Threadtest2 thread3=new Threadtest2();
//		thread1.start();
//		thread2.start();
//		thread2.suspend();
//		thread3.start();
//		thread2.resume();
		System.out.println(Thread.currentThread());
	}

}

class Threadtest2 extends Thread{

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				sleep(1000);
				System.out.println(i);
				System.out.println(Thread.currentThread().getName()+"incontroll");
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}