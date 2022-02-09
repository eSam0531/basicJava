package com.hcl.java8features.concepts;

import java.util.ArrayList;
import java.util.List;

import com.hcl.java8features.entity.Employee;

public class MethodReferencewithForEach {

	public static void main(String[] args) {
		// creates empty ArrayList of type Employee
		List<Employee> empList = new ArrayList<>();

		// adds new Employee objects to ArrayList
		empList.add(new Employee(94840, "John", "Boston", 30000, 21));
		empList.add(new Employee(34342, "Alexis", "Orlando", 50000, 27));
		empList.add(new Employee(98354, "Sarah", "Houston", 80000, 30));
		empList.add(new Employee(95732, "Katie", "Boston", 90000, 29));
		empList.add(new Employee(98765, "Brandon", "Tokyo", 40000, 24));
		empList.add(new Employee(69385, "Eric", "Tokyo", 55000, 35));
		
		//prints each element of the list utilizing method reference
		empList.forEach(System.out::println);;

	}

}
