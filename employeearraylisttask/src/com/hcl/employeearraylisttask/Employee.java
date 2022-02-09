package com.hcl.employeearraylisttask;

public class Employee {

	int employeeID;
	String employeeName;
	String city;
	int salary;
	int age;

	// Constructor
	public Employee(int employeeID, String employeeName, String city, int salary, int age) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.city = city;
		this.salary = salary;
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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
		return "Employee ID: " + employeeID + " Employee Name: " + employeeName +
				" Location: " + city + "Salary: " + salary + "Age: " + age;
	}

}
