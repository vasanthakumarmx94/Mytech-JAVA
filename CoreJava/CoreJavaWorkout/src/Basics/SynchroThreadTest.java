package Basics;

public class SynchroThreadTest extends Thread {

	
	
	@Override
	public void run() {
		System.out.println("Thread name:"+this.getName());
		System.out.println("Hold Lock?"+this.holdsLock(this));//default false
		
		synchronized(this) {
			System.out.println("Hold Lock?"+this.holdsLock(this));
			
		}
	}

	public static void main(String[] args) {
//		SynchroThreadTest tread=new SynchroThreadTest();
//		tread.start();
		Printer printer = new Printer();
		
		new PC1(printer).start();
		new PC2(printer).start();
	}

}

class Printer{
	//synchronized 
	 void doPrint(String doc) {
		System.out.println("Non synch block");
		synchronized(this) {
		for(int i=0;i<=10;i++) {
			System.out.println("Printing "+doc+":"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		}
	}
}
class PC1 extends Thread{
	Printer p;
	
	public PC1(Printer p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		p.doPrint("Java");
	}
	
}
class PC2 extends Thread{
	Printer p;
	
	public PC2(Printer p) {
		super();
		this.p = p;
	}
	@Override
	public void run() {
		p.doPrint("Python");
	}
	
}
