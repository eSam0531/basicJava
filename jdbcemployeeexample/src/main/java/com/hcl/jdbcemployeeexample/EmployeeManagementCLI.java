package com.hcl.jdbcemployeeexample;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author esmee
 *
 */
public class EmployeeManagementCLI {

	/**
	 * used to print blank lines on screen for readability
	 */
	public static void blankLine() {
		System.out.println();
	}

	public static void main(String[] args) throws SQLException, ParseException {
		// scanner to receive input from CLI
		Scanner kb = new Scanner(System.in);
		// flag to maintin do-while loop
		boolean exit = false;
		//Strings for menu options
		String opt1 = "1. Create new employee record";
		String opt2 = "2. Retrieve all employees records";
		String opt3 = "3. Retrieve an employee record";
		String opt4 = "4. Update an employee record";
		String opt5 = "5. Delete an employee record";
		String opt6 = "6. Quit/Exit";
		//int to hold user option selection
		int opt = 0;

		// Welcome message
		System.out.println("Welcome to the Employee Management System");
		blankLine();

		do {
			// options menu
			System.out.println("Please select an option:\n" + opt1 + "\n" + opt2 + "\n" + opt3 + "\n" + opt4 + "\n"
					+ opt5 + "\n" + opt6);
			// get user option
			opt = kb.nextInt();
			kb.nextLine();

			switch (opt) {
			case 1:
				System.out.println(opt1+":");
				// get name
				System.out.print("Please employee name: ");
				String empName = kb.next();
				kb.nextLine();
				// get date of birth
				System.out.print("Please enter employee date of birth (mm-dd-yyyy): ");
				String sdob = kb.next();
				// flag for while loop to format and ensure correct format entry
				Date dob = null;
				dob = DateFormatter.stringToDate(sdob);	
				kb.nextLine();
				System.out.print("Please enter employee salary: ");
				int salary = kb.nextInt();
				kb.nextLine();
				System.out.println("Please enter employee age: ");
				int age = kb.nextInt();
				Employee1 newEmp = new Employee1(empName,dob,salary,age);
				JDBCInsertRecord.insertRecord(newEmp);
				break;
			case 2:
				System.out.println(opt2+":");
				break;
			case 3:
				System.out.println(opt3+":");
				break;
			case 4:
				System.out.println(opt4+":");
				break;
			case 5:
				System.out.println(opt5+":");
				break;
			case 6:
				System.out.println("Good-bye");
				// change flag to exit do-while loop
				exit = true;
				break;
			default:
				System.out.println("Invalid option please try again.");
				break;
			}

		}while(!exit);

	kb.close();

}}
