package com.hcl.java8features.concepts;

import java.util.function.Predicate;

public class PredicateConcept {

	public static void main(String[] args) {
		
		Predicate<Integer> lessThan = x -> (x<50);
		
		System.out.println(lessThan.test(30));
		System.out.println(lessThan.test(90));
	}

}
