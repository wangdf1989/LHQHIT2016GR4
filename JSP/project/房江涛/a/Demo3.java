package com.qhit.a;

public class Demo3 {
	
	
	public static void main(String[] args) {
		
		String s="ysbc";
		String ss="abcdefc";
	
		
		
		
		
		//截取下标对应字母 返回单个字母
	    char a=  s.charAt(0);	
		//比字符是否相同 相同返回true,否则返回false
		if(s.equals(ss)){
			System.out.println("dddd");
		}else{
			System.out.println("ccccccc");
		}
		 
		//获取字母所在字符串中最左边下标位置
		int c=   ss.indexOf("1");
		System.out.println(c);
		//获取字母所在字符串中最右边下标位置
		int d=   ss.lastIndexOf("c");
		
		//字符串的截取 包含头 不包含尾
		String f=  ss.substring(2,4);
		System.out.println(f);
		
		//去空处理,只能处理前后空格
		System.out.println(ss.trim());
		
		//使用空格截取字符串
		//{"a","bc","defc"}  
		String[] w= ss.split(" ");
		
		String g="";
		for (int i = 0; i < w.length; i++) {
			
			g=g+w[i];
		}
		
		System.out.println(g);
		//检查字符串是否包含单个字符,如果包含返回true否者返回false
		boolean  p=  ss.contains("k");
		
		System.out.println(p);
		//字符串长度
		System.out.println(s.length());
		
	}
	
	

}
