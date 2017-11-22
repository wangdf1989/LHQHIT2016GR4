package com.qhit.a;

import java.util.Arrays;
import java.util.Scanner;

public class Demo6 {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ÇëÊäÈë10¸öÊı×Ö:");
		int[] a=new int[10];
		
		for (int i = 0; i < 10; i++) {
			  a[i]= sc.nextInt();
			
		}
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		
		
		
		
	}

}
