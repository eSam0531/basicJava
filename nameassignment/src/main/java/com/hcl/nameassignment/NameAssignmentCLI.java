package com.hcl.nameassignment;

import java.util.Scanner;

public class NameAssignmentCLI {

	public static void main(String[] args) throws NameLengthException {
		Scanner kb = new Scanner(System.in);
		String name = "";
		String first = "";
		String mid = "";
		String last = "";
		boolean valid = false;

		while (!valid) {
			try {
				System.out.println("Please enter your full name:");
				name = kb.nextLine();
				if (name.length() < 10 || name.length() > 15) {
					throw new NameLengthException("NameLengthException");
				}
				valid = true;
			} catch (NameLengthException e) {
				System.out.println(e);
				System.out.println("Name exceeds allowed length. Please try again.");
			}
		}
		kb.close();
		
		String[] namearr = name.split(" ");
		
		if (namearr.length == 2) {
			first = namearr[0];
			last = namearr[1];
		}
		else if (namearr.length == 3) {
			first = namearr[0];
			mid = namearr[1];
			last = namearr[2];
		}
		
		System.out.println("First name: " + first);
		System.out.println("Middle name: " + mid);
		System.out.println("Last name: " + last);

	}

}
