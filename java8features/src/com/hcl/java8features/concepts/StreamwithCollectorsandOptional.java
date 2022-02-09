package com.hcl.java8features.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.hcl.java8features.entity.Employee;

public class StreamwithCollectorsandOptional {

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

		// stream used to filter employees located in Boston and collected to another
		// list then printed
		List<Employee> empList2 = empList.stream().filter(emp -> emp.getCity().equals("Boston"))
				.collect(Collectors.toList());
		empList2.forEach(System.out::println);
		System.out.println();
		
		// stream to find average age of all employees
		OptionalDouble opt = empList.stream().mapToDouble(emp -> emp.getAge()).average();
		double avg = 0;
		try {
			avg = opt.getAsDouble();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		System.out.println("The average employee age is " + Math.round(avg) + ".");
		System.out.println();
		
		//Parallel stream filter employees with age greater than 28
		List<Employee> opt2 = empList.parallelStream().filter(emp -> emp.getAge()>28).collect(Collectors.toList());
		opt2.forEach(System.out::println);
		

	}

}
