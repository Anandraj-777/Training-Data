package com.hlag.lambda;

public class EvenOrodd {

	   public static void main(String[] args) {
		
		   NumberCheck numberCheck = (number)-> {
			   if(number %2==0) {
				   System.out.println(number + " is even");
			   }
			   else {
				   System.out.println(number + " is odd");
			   }			   
		   };
		   
		   numberCheck.check(10);
		   numberCheck.check(7);
	}
}
