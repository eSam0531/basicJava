package com.hcl.jdbcemployeeexample;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		// flag to maintain do-while loop
		boolean exit = false;
		//Strings for menu options
		String opt1 = "1. Create new employee record";
		String opt2 = "2. Retrieve all employees records";
		String opt3 = "3. Retrieve an employee record";
		String opt4 = "4. Update an employee's salary";
		String opt5 = "5. Delete an employee record";
		String opt6 = "6. Quit/Exit";
		//int to hold user option selection
		int opt = 0;
		//employee object list if necessary for option 2
		List<Employee1> empList = new ArrayList<>();

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
				// format dob string to Date
				Date dob = null;
				dob = DateFormatter.stringToDate(sdob);	
				kb.nextLine();
				// get salary
				System.out.print("Please enter employee salary: ");
				int salary = kb.nextInt();
				//kb.nextLine();
				//get age
				System.out.println("Please enter employee age: ");
				int age = kb.nextInt();
				//create new employee object
				Employee1 newEmp = new Employee1(empName,dob,salary,age);
				// insert new employee record to database
				JDBCInsertRecord.insertRecord(newEmp);
				break;
			case 2:
				System.out.println(opt2+":");
				//gets all employee records from database
				empList = JDBCSelectAllRecords.selectAll();
				//foreach loop to print each employee record
				empList.forEach((emp) -> System.out.println(emp.toString()));
				break;
			case 3:
				System.out.println(opt3+":");
				System.out.print("Please enter the empID you wish to retrieve: ");
				int empID = kb.nextInt();
				//prints employee recored retrieved from database
				System.out.println(JDBCSelectOneRecord.selectOne(empID).toString());
				break;
			case 4:
				System.out.println(opt4+":");
				System.out.print("Please enter the employee ID you would like to update: ");
				int id = kb.nextInt();
				System.out.print("\nPlease enter the new salary: ");
				int sal = kb.nextInt();
				JDBCUpdateEmpSalary.updateRecord(sal,id);
				break;
			case 5:
				System.out.println(opt5+":");
				System.out.print("Please enter the employee ID to be deleted:");
				int i = kb.nextInt();
				JDBCDeleteRecord.deleteRecord(i);
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
