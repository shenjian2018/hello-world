package learn.Synchronized;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;


class myDeamonThread implements Runnable {

	public void run() {

		try {
			System.out.println("�������ػ��߳�");
			writeToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�ػ��߳̽�����");
	}

	private void writeToFile() throws IOException, InterruptedException {
		File file = new File("F:" + File.separator + "class" + File.separator + "1.txt");
		OutputStream osm = new FileOutputStream(file, true);
		int i = 0;
		while (i < 888) {
			osm.write(("\r\nword" + i).getBytes());
			System.out.println("�ػ��߳�" + Thread.currentThread().getName() + "���ļ�д����word" + i++);
			Thread.sleep(1000);
		}

	}
}

public class DeamonThread {

	public static void main(String[] args) {
		System.out.println("���������߳�" + Thread.currentThread().getName());
		myDeamonThread deamon = new myDeamonThread();
		Thread th = new Thread(deamon);
		th.setDaemon(true);
		th.start();
		
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("�˳������߳�" + Thread.currentThread().getName());
	}
}
