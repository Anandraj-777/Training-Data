package com.hlag.lambda;

import java.util.function.Function;

public class FunctionalInterface {

	public static void demo() {
		Function<String, Integer> function = x -> x.length();
		System.out.println(function.apply("Anand"));
	}

	public static void demo2() {
		Function<Integer, Boolean> calculateValue = x -> x % 7 == 0;
		System.out.println(calculateValue.apply(8));
	}
	
	public static void demo3(Iops iops) {
		Function<String, Integer> function = x-> x.length();
		Function<Integer, Integer> function2 = x-> x*2;
		
		int result = function.andThen(function2).apply("Anand");
		System.out.println(result);
	}

	public static void main(String[] args) {
		demo();
		demo2();
	}
}
