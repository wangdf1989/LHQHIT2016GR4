package com.qhit.a;

public class Demo4 {
	
	public static void main(String[] args) {
		
		
		 Person p1= new Person();
		 Person p2= new Person();
	
		 
		 String a=new String("aaa");
		 String b=new String("aaa");
		 
		 String c="fff"; 
		 String d="fff";
		 
		if(p1.equals(p2)){
			
			System.out.println("aaaaaaaaaa");
			
		}else{
			
			System.out.println("bbbbbbbbbbb");
		}
		
		 
	   if(a.equals(b)){
			
			System.out.println("ccccccccc");
			
		}else{
			
			System.out.println("dddddd");
		}
		
	   if(c.equals(d)){
			
			System.out.println("eeeeeee");
			
		}else{
			
			System.out.println("fffffffffffffff");
		}
		
		
	   
	  /* ==和equals的区别?
		==常用于比较8种基本数据类型,比较的是对象在内存中的地址符
		equals常用于String字符串的比较,比较的是字符串的值
		==比较的栈内存中的地址符,equals比较堆内存中的*/
		
		
		
		
	}
	

}
