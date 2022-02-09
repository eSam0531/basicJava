package com.hcl.java8features.concepts;

@FunctionalInterface
interface Inter {
	default void defaultMessage() {
		System.out.println("Hello from the default method");
	}
	
	static void helloworld() {
		System.out.println("Hello,World!");
	}
	
	public int abstractMethod(String s);
	
}

public class DefaultandStaticMethods {

	public static void main(String[] args) {
		
		String test = "testString";
		//calling the static method
		Inter.helloworld();
		//lambda implementation of abstract method
		Inter stringTest = s -> s.length();
		
		System.out.println(test);
		System.out.println(stringTest.abstractMethod(test));
		stringTest.defaultMessage();

	}

}
