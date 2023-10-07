package Basics;

public class ThreadTask {

	public static void main(String[] args) throws InterruptedException {
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		evenThread evn=new evenThread(x,y);
		OddThread odd=new OddThread(x,y);
		evn.start();
		//evn.suspend();
		//evn.sleep(1000);
		evn.join();
		odd.start();
		//odd.suspend();
		//evn.resume();
	}

}
class evenThread extends Thread{
	int n;
	int m;

	public evenThread(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}
	@Override
	public void run() {
		System.out.println("Even Numbers:");
		for(int i=n;i<m;i++) {
			if(i%2==0) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
class OddThread extends Thread{
	int n;
	int m;

	public OddThread(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}
	@Override
	public void run() {
		System.out.println("Odd Numbers:");
		for(int i=n;i<m;i++) {
			if(i%2!=0) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}


