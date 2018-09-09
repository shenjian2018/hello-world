package learn.Synchronized;

class MyThread extends Thread {
	private int ticket = 5;
	private String name;

	public MyThread(String name) {
     this.name=name;
	}

	@Override
	public void run() {
		while(ticket>0) {
			ticket--;
			System.out.println(name+"卖了1张票,还剩余"+ticket+"张票");
		}
	}

}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread  mt0=new MyThread("窗口0");
		MyThread  mt1=new MyThread("窗口1");
		MyThread  mt2=new MyThread("窗口2");
		mt0.start();
		mt1.start();
		mt2.start();
	}

}
