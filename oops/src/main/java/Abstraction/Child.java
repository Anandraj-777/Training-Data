package Abstraction;

public class Child extends Parents{

	@Override
	void study() {
		System.out.println("Selecting Course");
	}

	 public static void main(String[] args) {
		Child chi = new Child();
		chi.study();
	}
}
