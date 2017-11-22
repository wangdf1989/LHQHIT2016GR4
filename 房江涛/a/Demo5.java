package com.qhit.a;

public class Demo5 {
	
	public static void main(String[] args) {
		
		//String w="ccccccc";
		StringBuffer sb=new StringBuffer("ccccccc");
		StringBuffer sb2=new StringBuffer("abdce");
		//在字符串后追加字符串
		sb.append("ddddddddddd");
		sb.append(sb2);
		System.out.println(sb.toString());
		String c="tttt";
		//查找字符串返回下标,没有返回-1
		int a= sb2.indexOf(c,1);
		System.out.println(a);
		//在字符串中插入新的字符串
		//sb2.insert(1, c);
		System.out.println(sb2.toString());
		//实现字符串的反转
		 // sb2.reverse();
		//System.out.println(sb2);
		
		//字符串替换
		sb2.replace(1, 3, "fff");
		System.out.println(sb2.toString());
		
	}

}
