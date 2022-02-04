package com.hcl.hospitalassignment;

import java.util.Comparator;

public class Doctor implements Comparable<Doctor> {

	private int doctorId;
	private String doctorName;
	private String specialty;

	/**
	 * 
	 * @param patientId
	 * @param patientName
	 * @param age
	 */
	public Doctor(int doctorId, String doctorName, String specialty) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialty = specialty;
	}

	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * compares doctorId
	 * 
	 * @param d
	 * @return
	 */
	public int compareTo(Doctor d) {
		return this.doctorId - d.doctorId;
	}

}

//compares doctorName
class DoctorNameCompare implements Comparator<Doctor> {

	public int compare(Doctor d1, Doctor d2) {
		return d1.getDoctorName().compareTo(d2.getDoctorName());
	}
}

// compares specialty
class SpecialtyCompare implements Comparator<Doctor> {

	public int compare(Doctor d1, Doctor d2) {
		return d1.getSpecialty().compareTo(d2.getSpecialty());
	}
}