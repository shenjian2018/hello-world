package com.jsm.produce;

public class Solution {

	public static int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;

	}
	
	public static int Number02(int n){
		int count=0;
		for (int i = 0; i <=32; i++) {
			
			if((n>>i & 1)==1){
				count++;	
			}
		}
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println(Number02(100));
		System.out.println(Integer.parseInt("1"));
	}
}