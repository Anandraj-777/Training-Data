package com.hlag.lambda;

@FunctionalInterface
interface I5 {
	 public boolean test();
		 
	 public default void test2() {
		 System.out.println("Hello From test2");
	 }
}