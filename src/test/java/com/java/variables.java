package com.java;

public class variables {
	
	int i=10; //instance vairable
	static int j=10; //static or class variable
	
	public int Add(int a , int b) {
		//a,b,sum are local variables.
		int sum = a+b; 
		System.out.println("sum:"+sum);
		return sum;
		
	}

	public static void main(String[] args) {
		
		System.out.println("insiede main method");
		variables obj = new variables();
		obj.Add(5,8);

	}

}
