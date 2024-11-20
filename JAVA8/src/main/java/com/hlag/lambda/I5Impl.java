package com.hlag.lambda;

class I5Impl implements I5 {

	@Override
	public boolean test() {
		System.out.println("Hello From test");
		return true;
	}
	 
	@Override
	public void test2() {
		System.out.println("test2 is overridden");
	}
}