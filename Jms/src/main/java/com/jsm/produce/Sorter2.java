package com.jsm.produce;
public class Sorter2 {

	public static void merge2SortedArray(int[] a, int[] b, int[] c) {
		// a数组的当前索引
		int i = 0;
		// b数组的当前索引
		int j = 0;
		// c数组的当前索引
		int k = 0;
		// 循环，只要a和b都没有遍历完就一直循环
		while (i < a.length && j < b.length) {
			// 如果当前a[i]比b[j]小，就把c[k]元素置为a[i],同时k++,i++
			if (a[i] < b[j]) {
				c[k++] = a[i++];
				// 否则,如果当前a[i]比b[j]大，就把c[k]元素置为b[j],同时k++,j++
			} else {
				c[k++] = b[j++];
			}
		}

		// 上个循环能够结束，说明a已经循环完或b已经循环完
		// 下述两个循环只能有一个满足循环条件
		// 只要a没有循环完，就把a中剩下的元素依次放入c中
		while (i < a.length) {
			c[k++] = a[i++];
		}
		// 只要b没有循环完，就把b中剩下的元素依次放入c中
		while (j < b.length) {
			c[k++] = b[j++];
		}
	}

	// 测试程序
	public static void main(String[] args) {
		// 待合并数组a
		int[] b = new int[] { 1, 4, 5, 7, 9 };
		// 待合并数组b
		int[] a = new int[] { 6, 8, 10, 11 };
		// c用来存放合并之后的数组
		int[] c = new int[a.length + b.length];
		merge2SortedArray(a, b, c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + "\t");
		}
	}

}