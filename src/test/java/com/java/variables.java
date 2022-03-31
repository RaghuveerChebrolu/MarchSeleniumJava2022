package com.java;

public class variables {
	
	int i=10; //instance vairable
	static int j=10; //static or class variable : wehen ever class is loaded into memory static variables will get initiliaze at first 
	boolean flag= true;
	public void Add(int a , int b) {
		//a,b,sum are local variables.
		int sum = a+b; 
		System.out.println("sum:"+sum);
		//return sum;
		
	}

	public static void main(String[] args) {
		
		System.out.println("insiede main method");
		variables obj = new variables();
		obj.Add(5,8);
System.out.println(obj.i);
System.out.println(j);
System.out.println("---------------");
System.out.println(j++);
System.out.println(++j);
System.out.println(~obj.i);
System.out.println(!obj.flag);
System.out.println(j>18?j:18);
	}

}
