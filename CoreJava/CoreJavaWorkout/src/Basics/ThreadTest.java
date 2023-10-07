package Basics;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		System.out.println("Threadi s  running");
		System.out.println(Thread.currentThread().getName());	
	}

	public static void main(String[] args) {
//		ThreadTest tt = new ThreadTest();
//		tt.start();
//		System.out.println(Thread.currentThread().getName());	
//		ThradTest2 tt2 = new ThradTest2();
//		Thread thread = new Thread(tt2);
//		thread.start();
//		System.out.println(Thread.currentThread().getName());	
//		Thradtest3 mt3 = new Thradtest3();
//		mt3.start();
//		System.out.println(Thread.currentThread().getName());
		Thradtest3 mt1 = new Thradtest3();
		Thradtest3 mt2 = new Thradtest3();
		Thradtest3 mt3 = new Thradtest3();
		
		mt1.start();
		//mt1.join();
		mt2.start();
		mt3.start();
	
	}

}

class ThradTest2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread 2 is running:"+Thread.currentThread().getName());

	}

}

class Thradtest3 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
