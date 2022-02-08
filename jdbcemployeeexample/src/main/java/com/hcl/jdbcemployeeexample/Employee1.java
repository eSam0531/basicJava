package com.hcl.jdbcemployeeexample;

import java.util.Date;

public class Employee1 {

	private int empID;
	private String empName;
	private Date dob;
	private int salary;
	private int age;

	public Employee1() {
		this.empID = 0;
		this.empName = null;
		this.dob = null;
		this.salary = 0;
		this.age = 0;

	}

	public Employee1(String empName, Date dob, int salary, int age) {
		this.empID = JDBCGetLastEmpID.getLastID() + 1;
		this.empName = empName;
		this.dob = dob;
		this.salary = salary;
		this.age = age;
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}

	/**
	 * 
	 * @param empID
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
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

	public String toString() {
		return "EmployeeID: " + this.empID + " Employee Name: " + this.empName + " Employee DOB: " + this.dob
				+ " Salary: " + this.salary + " Age: " + this.age;
	}
}
