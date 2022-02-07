package com.hcl.employeearraylisttask;

public class Employee {

	int employeeID;
	String employeeName;
	String city;

	// Constructor
	public Employee(int employeeID, String employeeName, String city) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.city = city;
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee ID: " + employeeID + " Employee Name: " + employeeName + " Location: " + city;
	}

}
