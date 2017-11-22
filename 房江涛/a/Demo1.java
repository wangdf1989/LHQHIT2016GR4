package com.qhit.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
	
	public static void main(String[] args) {
		
		//静态声明
		int[] b={1,2,6};
		
		//动态创建数组
		int[] scores=new int[10];
		
		scores[0]=95;
		scores[1]=92;
		scores[2]=91;
		scores[3]=75;
		scores[4]=95;
		scores[5]=95;
		scores[6]=99;
		scores[7]=93;
		scores[8]=90;
		scores[9]=95;
		
		System.out.println(Arrays.toString(scores));
		
	    //对数组进行排序,从小到大
		Arrays.sort(scores);
		//输出打印数组中的信息
		System.out.println(Arrays.toString(scores));
		
		int[] cc=new int[10];
		for (int i = scores.length-1; i >=0; i--) {
			
			cc[scores.length-1-i] = scores[i];
			
		}
		
		System.out.println(Arrays.toString(cc));
		//在数组中查询是否存在一个值,存在返回对应下标,不存在返回-1
		//int c=  Arrays.binarySearch(scores,10);
		//System.out.println(c);
		
		//转换成list集合
		//List s= Arrays.asList(scores);
		//比较数组中的元素是否一样,一样返回true不一样返回false
		//boolean  k=  Arrays.equals(b, scores);
		//System.out.println(k);
		
		
		
		
		
		
		
		
	}
	
	

}
