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
			System.out.println(name+"����1��Ʊ,��ʣ��"+ticket+"��Ʊ");
		}
	}

}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread  mt0=new MyThread("����0");
		MyThread  mt1=new MyThread("����1");
		MyThread  mt2=new MyThread("����2");
		mt0.start();
		mt1.start();
		mt2.start();
	}

}
