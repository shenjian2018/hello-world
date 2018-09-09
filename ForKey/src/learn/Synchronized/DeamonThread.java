package learn.Synchronized;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;


class myDeamonThread implements Runnable {

	public void run() {

		try {
			System.out.println("进入了守护线程");
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("守护线程结束了");
	}

	private void writeToFile() throws IOException, InterruptedException {
		File file = new File("F:" + File.separator + "class" + File.separator + "1.txt");
		OutputStream osm = new FileOutputStream(file, true);
		int i = 0;
		while (i < 888) {
			osm.write(("\r\nword" + i).getBytes());
			System.out.println("守护线程" + Thread.currentThread().getName() + "像文件写入了word" + i++);
			Thread.sleep(1000);
		}

	}
}

public class DeamonThread {

	public static void main(String[] args) {
		System.out.println("进入了主线程" + Thread.currentThread().getName());
		myDeamonThread deamon = new myDeamonThread();
		Thread th = new Thread(deamon);
		th.setDaemon(true);
		th.start();
		
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("退出了主线程" + Thread.currentThread().getName());
	}
}
