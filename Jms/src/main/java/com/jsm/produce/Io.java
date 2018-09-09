package com.jsm.produce;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Io {

	public void memcpy(byte[] buffer, int from, int length, int to) {
		try {
			File f = new File("E:/1.txt");
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
			fis.read(buffer, 0, length);
			FileOutputStream fos = new FileOutputStream("E:");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(buffer, 0, length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
