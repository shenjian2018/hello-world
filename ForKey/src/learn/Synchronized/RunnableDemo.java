package learn.Synchronized;
class MyRunnable implements Runnable{
	private int ticket = 5;
	@Override
	public void run() {
		while(ticket>0) {
			ticket--;
			System.out.println(Thread.currentThread().getName()+"����1��Ʊ,��ʣ��"+ticket+"��Ʊ");
		}		
	}
	
}
public class RunnableDemo {
	public static void main(String[] args) {
		MyRunnable  my=new MyRunnable();
		Thread  th0=new Thread(my, "����0");
		Thread  th1=new Thread(my, "����1");
		Thread  th2=new Thread(my, "����2");
		th0.start();
		th1.start();
		th2.start();
	}
}
