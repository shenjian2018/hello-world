package com.fanxing;

import java.util.HashSet;
import java.util.Set;

public class Lattee extends Coffee {

	
	public static void main(String[] args) { 
		Integer[] a = new Integer[] { 1, 4,  5, 9, 10, 10 };  
		  
        Set<Integer> set = new HashSet<Integer>();  
        for (int i = 0; i < a.length; i++) {  
            set.add(a[i]);  
        } 
	}
}
