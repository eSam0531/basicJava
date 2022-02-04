package com.hcl.hospitalassignment;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {

	private int patientId;
	private String patientName;
	private int age;

	/**
	 * 
	 * @param patientId
	 * @param patientName
	 * @param age
	 */
	public Patient(int patientId, String patientName, int age) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	 * compares patient id
	 * 
	 * @param p
	 * @return
	 */
	public int compareTo(Patient p) {
		return this.patientId - p.patientId;
	}
}

//compares patient age
class AgeCompare implements Comparator<Patient> {

	public int compare(Patient p1, Patient p2) {
		return p1.getAge() - p2.getAge();
	}
}

// compares patientName
class PatientNameCompare implements Comparator<Patient> {

	public int compare(Patient p1, Patient p2) {
		return p1.getPatientName().compareTo(p2.getPatientName());
	}
}
