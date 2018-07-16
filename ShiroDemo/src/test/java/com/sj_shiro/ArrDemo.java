package com.sj_shiro;

public class ArrDemo {
	
	public static void main(String[] args) {
		int[] numbers = { 2, 3, 1, 0, 2, 5, 3 };
		int length = 7;
		int[] duplication = new int[1];
		boolean bool = duplicate(numbers, length, duplication);
		System.out.println(bool + " " + duplication[0]);
	}

	public static boolean duplicate(int numbers[], int length, int[] duplication) {

		if (numbers == null || length <= 0) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			if (numbers[i] < 0 || numbers[i] >= length)
				return false;
		}
		for (int j = 0; j < length; j++) {
			while (numbers[j] != j) {
				if (numbers[j] == numbers[numbers[j]]) {// true说明有重复
					duplication[0] = numbers[j];
					return true;
				}
				int temp = numbers[j];
				numbers[j] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
}
