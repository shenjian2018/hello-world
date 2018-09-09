package learn.Synchronized;
class MyRunnable implements Runnable{
	private int ticket = 5;
	@Override
	public void run() {
		while(ticket>0) {
			ticket--;
			System.out.println(Thread.currentThread().getName()+"卖了1张票,还剩余"+ticket+"张票");
		}		
	}
	
}
public class RunnableDemo {
	public static void main(String[] args) {
		MyRunnable  my=new MyRunnable();
		Thread  th0=new Thread(my, "窗口0");
		Thread  th1=new Thread(my, "窗口1");
		Thread  th2=new Thread(my, "窗口2");
		th0.start();
		th1.start();
		th2.start();
	}
}
