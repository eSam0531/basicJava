package com.hcl.linkedlistassignment;

import java.util.LinkedList;

public class LinkedListAssignment {

	public static void main(String[] args) {
		LinkedList<String> dogs = new LinkedList<>();
		dogs.add("American Pitbull Terrier");
		dogs.add("Dalmation");
		dogs.add("German Shepard");
		dogs.add("Boxer");
		dogs.add("Labrador Retriever");
		dogs.add("Poodle");
		dogs.add("Dobermann");
		dogs.add("Shiba Inu");
		dogs.add("Belgian Malionis");
		
		// print all
		System.out.println("All breeds:");
		printAllelements(dogs);
		newLine();
		
		//use getFirst() to display the first item in the list
		System.out.println("Breed at first element");
		System.out.println(dogs.getFirst());
		newLine();
		
		//use removeFirst() to remove the first item from the list
		dogs.removeFirst();
		System.out.println("All breeds after removal of first element");
		printAllelements(dogs);
		newLine();
		
		//user addFirst() to add at the first element
		dogs.addFirst("Border Collie");
		System.out.println("All breeds after addition at first element");
		printAllelements(dogs);
		newLine();
		
		//use getLast() to display the last item in the list
		System.out.println("Breed at last element");
		System.out.println(dogs.getLast());
		newLine();
		
		//use addLast() to add to end of linked list
		dogs.addLast("Cane Corso");
		System.out.println("All breeds after addition at last element");
		printAllelements(dogs);	
		newLine();
		
		//use removeLast() to remove the last item on the list
		dogs.removeLast();
		System.out.println("All breeds after removal at last element");
		printAllelements(dogs);
		

	}
	
	public static void newLine() {
		System.out.println("");
	}
	
	public static void printAllelements(LinkedList<String> ll) {
		System.out.println(ll);
	}

}

