package com.hcl.java8features.concepts;

import java.util.function.BiFunction;

public class BiFunctionConcept {

	public static void main(String[] args) {
		
		BiFunction<Double, Double, Double> sideA = (b,c) -> Math.sqrt(Math.pow(c, 2) - Math.pow(b,2));
		
		System.out.println("Given b = 5 and c = 13 for a Right Triangle, a = " + sideA.apply(5.0, 13.0));

	}

}
