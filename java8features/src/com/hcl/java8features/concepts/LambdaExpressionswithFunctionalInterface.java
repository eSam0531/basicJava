package com.hcl.java8features.concepts;
//functional interface
interface Triangle{
	double calcSideA(double b, double c);
}

public class LambdaExpressionswithFunctionalInterface {

	public static void main(String[] args) {
		//finding A of a right triangle given B and C
		//lambda expression using functional interface
		Triangle sideA = (b,c) -> Math.sqrt(Math.pow(c, 2) - Math.pow(b,2));
		
		double a = sideA.calcSideA(5,13);
		
		System.out.println("The length of SideA is " + a + " given SideB = 5 and SideC = 13 in a Right Triangle");
		
	}

}
