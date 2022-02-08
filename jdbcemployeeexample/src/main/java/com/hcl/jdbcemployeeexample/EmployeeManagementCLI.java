package com.hcl.jdbcemployeeexample;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
		// Strings for menu options
		String opt1 = "1. Create new employee record";
		String opt2 = "2. Retrieve all employees records";
		String opt3 = "3. Retrieve an employee record";
		String opt4 = "4. Update an employee's salary";
		String opt5 = "5. Delete an employee record";
		String opt6 = "6. Quit/Exit";
		// int to hold user option selection
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
				System.out.println(opt1 + ":");
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
				// kb.nextLine();
				// get age
				System.out.println("Please enter employee age: ");
				int age = kb.nextInt();
				// create new employee object
				Employee1 newEmp = new Employee1(empName, dob, salary, age);
				// insert new employee record to database
				JDBCInsertRecord.insertRecord(newEmp);
				break;
			case 2:
				System.out.println(opt2 + ":");
				// to hold records retrieved from database
				List<Employee1> empList = new ArrayList<>();
				// gets all employee records from database
				empList = JDBCSelectAllRecords.selectAll();
				// foreach loop to print each employee record
				//empList.forEach((emp) -> System.out.println(emp.toString()));
				System.out.println("Would you like to filter this list (1 = yes, any other number = no)?");
				int filter = kb.nextInt();
				if (filter == 1) {
					empList = filterList();
				}
				empList.forEach((emp) -> System.out.println(emp.toString()));
				break;
			case 3:
				System.out.println(opt3 + ":");
				System.out.print("Please enter the empID you wish to retrieve: ");
				int empID = kb.nextInt();
				// prints employee recored retrieved from database
				System.out.println(JDBCSelectOneRecord.selectOne(empID).toString());
				break;
			case 4:
				System.out.println(opt4 + ":");
				System.out.print("Please enter the employee ID you would like to update: ");
				int id = kb.nextInt();
				System.out.print("\nPlease enter the new salary: ");
				int sal = kb.nextInt();
				// updates the salary of a specific record
				JDBCUpdateEmpSalary.updateRecord(sal, id);
				break;
			case 5:
				System.out.println(opt5 + ":");
				System.out.print("Please enter the employee ID to be deleted:");
				int i = kb.nextInt();
				// deletes record from database
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

		} while (!exit);

		kb.close();

	}
	
	public static List<Employee1> filterList() throws SQLException{
		Scanner k = new Scanner(System.in);
		String choices = null;
		
		HashMap<Integer,String> filters = new HashMap<>();
		filters.put(1, "salary ");
		filters.put(2, "empName like ");
		filters.put(3, "age ");
		
		
		System.out.println("Would you like to filter by: " +
				"\n1.salary \n2.first letter of employee name" +
				"\n3.age \nPlease enter digits separated by commas");
		choices = k.nextLine();
		String[] choiceArr = choices.split(",");
		int[] intChoice = new int[choiceArr.length];
		
		for (int i = 0; i < intChoice.length; i++) {
			intChoice[i] = Integer.parseInt(choiceArr[i]);
		}
		
		for(int choice : intChoice) {
			System.out.println(choice);
		}
		
		String message = "select empID, empName, dob, salary, age from employees where ";
		StringBuilder sb = new StringBuilder(message);
		
		
		for(int i = 0; i<intChoice.length; i++) {
			if(intChoice[i] == 1) {
				System.out.println("What salary comparison would you like(<,>,<=,>=,==,!=)?");
				String comp = k.nextLine();
				System.out.println("What salary amount do you want to set as your condition?");
				String sal = k.nextLine(); 
				sb.append(filters.get(1) + comp + " " + sal);
			} else if (intChoice[i] == 2) {
				System.out.println("What letter would you like the employee names to start with?");
				String letter = k.nextLine();
				sb.append(filters.get(2) + "'" + letter + "%'");
			} else if(intChoice[i] == 3) {
				System.out.println("What age comparison would you like(<,>,<=,>=,==,!=)?");
				String comp2 = k.nextLine();
				System.out.println("What age do you want to set as your condition?");
				String age = k.nextLine(); 
				sb.append(filters.get(3) + comp2 + " " + age);
			}
			if(intChoice.length>i+1) {
				sb.append(" and ");
			}
			
		}
		sb.append(";");
		
		String finalmessage = sb.toString();
		List<Employee1> list = new ArrayList<>();
		
		list = JDBCFilterRecords.filterList(finalmessage);
		
		return list;
		
	}
}
