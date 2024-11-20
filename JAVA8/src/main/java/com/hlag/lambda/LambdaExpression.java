package com.hlag.lambda;

import java.util.HashMap;
import java.util.Map;

public class LambdaExpression {

	public static void main(String[] args) {
		
//		I5 i5 = new I5Impl();
//		boolean result = i5.test();
//		i5.test2();
		
		I5 i6 = ()-> true;
		
		System.out.println(i6.test());
		i6.test2();
		
		I5 i5 = new I5() {

			@Override
			public boolean test() {
				// TODO Auto-generated method stub
				return false;
			}
           @Override
           public void test2() {
        	   System.out.println("test2 is overridden");
           }
		};
		i5.test2();
		
//		Iops iops = (int a, int b)-> a+b;
//		int res = iops.add(15,13);
//		System.out.println(res);
		demo((a,b)-> a+b+10);
	}
		public static void demo(Iops iops)	{
			System.out.println(iops.add(20,20));
	  }
		
		public static void demo2() {
	        Map<String, Integer> map = new HashMap<>();
	        map.put("A", 10);
	        map.put("B", 20);
	        map.put("C", 30);
	        map.put("D", 40);
	        map.put("E", 50);

	        // Iterate through the map and print each key-value pair
	        map.forEach((k, v) -> {
	            System.out.println(k + ": " + v);  // Print the key and value
	        });
	    }
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	