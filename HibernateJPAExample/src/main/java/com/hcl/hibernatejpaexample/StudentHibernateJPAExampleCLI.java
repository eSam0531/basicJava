package com.hcl.hibernatejpaexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hcl.hibernatejpaexample.JPAUtils.JPACRUDOps;
import com.hcl.hibernatejpaexample.entity.Student;

/**
 * A. Insert a record into table B. Find a particular row data specific to a id
 * from student table C. Find all the students data. D. Update a particular row
 * with the given id. E. Delete a row with the given id.
 */
public class StudentHibernateJPAExampleCLI {

	public static void main(String[] args) {
		// scanner to receive input from CLI
		Scanner kb = new Scanner(System.in);
		// flag to maintain do-while loop
		boolean exit = false;
		// Strings for menu options
		String opt1 = "1. Create new student record";
		String opt2 = "2. Retrieve a student record";
		String opt3 = "3. Update a student record";
		String opt4 = "4. Delete a student record";
		String opt5 = "5. Retrieve all student records";
		String opt6 = "6. Quit/Exit";
		// int to hold user option selection
		int opt = 0;

		// Welcome message
		System.out.println("Welcome to the Student Management System");

		do {
			// options menu
			System.out.println();
			System.out.println("Please select an option:\n"+opt1+"\n"+opt2 
					+"\n"+opt3+"\n"+opt4+"\n"+opt5+"\n"+opt6);
			opt = kb.nextInt();
			kb.nextLine();

			switch (opt) {
			case 1:
				System.out.println(opt1);
				//get data for Student record
				String[] s = getData(kb);
				//insert entity to table in database
				JPACRUDOps.insertEntity(s[0], s[1], s[2]);
				break;
			case 2:
				System.out.println(opt2);
				Long id = getID(kb);
				JPACRUDOps.findEntity(id);
				break;
			case 3:
				System.out.println(opt3);
				Long i = getID(kb);
				String[] t = getData(kb);
				JPACRUDOps.updateEntity(i, t[0], t[1], t[2]);
				break;
			case 4:
				System.out.println(opt4);
				Long num = getID(kb);
				JPACRUDOps.removeEntity(num);
				break;
			case 5:
				System.out.println(opt5);
				List<Student> students = new ArrayList<>();
				students = JPACRUDOps.getAllEntities();
				students.forEach(System.out::println);
				break;
			case 6:
				System.out.println("Good-bye");
				exit = true;
				break;
			default:
				System.out.println("Invalid Entry. Please try again.");
				break;
			}

		} while (!exit);

		kb.close();
	}

	private static String[] getData(Scanner kb) {
		String[] data = new String[3];
		String[] req = {"First Name: ", "Last Name: ", "Email: "};
		
		for(int i = 0; i<req.length; i++) {
			System.out.print(req[i]);
			data[i] = kb.next();
			kb.nextLine();
		}
		
		return data;
	}
	
	public static Long getID(Scanner kb) {
		System.out.println("StudentID: ");
		return kb.nextLong();
		
	}
	
}
