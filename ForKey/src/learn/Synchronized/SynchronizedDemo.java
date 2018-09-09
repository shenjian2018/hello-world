package learn.Synchronized;

public class SynchronizedDemo {
	// 共享变量
	private boolean ready = false;
	private int result = 0;
	private int number = 1;

	public void write() {
		ready = true;
		number = 2;
	}

	public void read() {
		if (ready) {
			result = number * 3;
		}
		System.out.println("result的值为：" + result);
	}

	@SuppressWarnings("unused")
	private class ReadWriteThread extends Thread {
		boolean flag;

		@SuppressWarnings("unused")
		public ReadWriteThread(boolean flag) {
		}

		public void run() {
			if (flag) {
				write();
			} else {
				read();
			}
		}

	}

	public static void main(String[] args) {
		SynchronizedDemo  syn=new SynchronizedDemo();
		syn.new ReadWriteThread(true).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		syn.new ReadWriteThread(false).start();
	}
}
