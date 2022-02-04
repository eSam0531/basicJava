package com.hcl.linkedlistassignment;

import java.util.LinkedList;

public class LinkedListAssignment {

	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		cars.add("Volvo");
		cars.add("Jaguar");
		cars.add("Toyota");
		cars.add("Dodge");
		cars.add("Ford");
		cars.add("Audi");
		cars.add("Lexus");
		cars.add("BMW");
		cars.add("Jeep");
		
		// print all
		System.out.println(cars);
		
		//use getFirst() to display the first item in the list
		System.out.println(cars.getFirst());
		
		//use removeFirst() to remove the first item from the list
		cars.removeFirst();
		System.out.println(cars);
		
		//use getLast() to display the last item in the list
		System.out.println(cars.getLast());
		
		//use addLast() to add to end of linked list
		cars.addLast("Mazda");
		System.out.println(cars);
		
		//use removeLast() to remove the last item on the list
		cars.removeLast();
		System.out.println(cars);
		

	}

}