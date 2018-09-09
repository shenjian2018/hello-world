package learn.Volatile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {
	private  volatile int number = 0;
	private Lock lock = new ReentrantLock();

	public int getNumber() {
		return this.number;
	}

	public void increase() {
		try {
			Thread.sleep(100);
			// synchronized (this) {
			lock.lock();
			try {
				this.number++;
			} finally {
				lock.unlock();
			}

			// }

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		VolatileDemo vd = new VolatileDemo();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					vd.increase();
				}
			}).start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("number : " + vd.getNumber());
	}
}
