package com.hlag.lambda;

public class CustomGreeter {

	 public static void main(String[] args) {
		
		 Greeter greeter = (name)-> System.out.println("Hello "+name);
		 
		 greeter.greet("Anand");
	}
}
