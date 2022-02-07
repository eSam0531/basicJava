/* 1.Add the employee details in the arraylist which has properties 
 * 	 as id,name & city,also to print the employee details which you 
 *   have added in the ArrayList.
 * 2.In which condition ArrayList should be used.
 * 3.For which scenarios Map should be used.
 * 4.For which scenarios Set should be used.
 */
package com.hcl.employeearraylisttask;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayListTask {

	public static void main(String[] args) {
		// creates empty ArrayList of type Employee
		List<Employee> empList = new ArrayList<>();
		
		// adds new Employee objects to ArrayList
		empList.add(new Employee(94840,"John","Boston"));
		empList.add(new Employee(34342,"Alexis","Orlando"));
		empList.add(new Employee(98354,"Sarah","Houston"));
		
		// calls method to print employees to CLI
		printEmployees(empList);
		
		// removes employee instance at index 1
		empList.remove(1);
		
		// calls method to print employees in CLI
		printEmployees(empList);

	}
	
	/**
	 * prints List of type Employee one line at a time
	 * @param empList
	 */
	public static void printEmployees(List<Employee> empList) {
		for(Employee employee: empList) {
			System.out.println(employee.toString());
		}
	}

}

/* #2
 * A good example use of an ArrayList would be in a banking app where
 * a user needs to review the transactions on their account. The
 * transactions could be loaded from the database for the particular
 * account to an arraylist then printed to screen for the user to 
 * review. This makes a quick easy retrieval and a quick print.
 * 
 * #3
 * A good example use of a Map could also work on a bank application.
 * However, this time would be on the internal banks side. Say a 
 * bank customer walks into a bank to ask questions on their account.
 * The banker would need to pull the customer's information. Using a
 * maps key, value pairing system, the banker would use the customers
 * account number as the key to load the customer's account
 * details(the value). This would work better than an array because
 * the map would allow the system to go straight to that key value instead
 * of having to iterate through a list.
 * 
 * #4
 * A good example use case of a Set would be if a banker needed to add
 * a new bank customer account. This would ensure there was no duplicates
 * added to the system. 
 * 
 */
