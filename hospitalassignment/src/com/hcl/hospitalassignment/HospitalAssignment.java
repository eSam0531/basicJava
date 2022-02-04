package com.hcl.hospitalassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HospitalAssignment {

	public static void main(String[] args) {
		// creating arraylist objects to hold data
		List<Patient> pList = new ArrayList<>();
		List<Doctor> dList = new ArrayList<>();

		// adding data
		pList.add(new Patient(104, "patient1", 34));
		pList.add(new Patient(107, "patient2", 60));
		pList.add(new Patient(102, "patient3", 24));

		dList.add(new Doctor(1000, "doctor1", "ortho"));
		dList.add(new Doctor(1045, "doctor2", "cardio"));
		dList.add(new Doctor(998, "doctor3", "neuro"));

		// Patient sorting:
		// sort by patientId uses Comparable
		System.out.println("Sorted by PatientId:");
		Collections.sort(pList);
		printPatients(pList);

		// sort by patientName uses Comparator
		System.out.println("\nSorted by Patient Name:");
		PatientNameCompare pNameCompare = new PatientNameCompare();
		Collections.sort(pList, pNameCompare);
		printPatients(pList);

		// sort by patientAge uses Comparator
		System.out.println("\nSorted by Patient Age:");
		AgeCompare ageCompare = new AgeCompare();
		Collections.sort(pList, ageCompare);
		printPatients(pList);

		// Doctor sorting:
		// sort by doctorID uses comparable
		System.out.println("\nSorted by DoctorId:");
		Collections.sort(dList);
		printDoctors(dList);
		
		//sort by Doctor Name
		System.out.println("\nSorted by Doctor Name");
		DoctorNameCompare doctorNameCompare = new DoctorNameCompare();
		Collections.sort(dList, doctorNameCompare);
		printDoctors(dList);
		
		// sort by Doctor specialty
		System.out.println("\nSorted by Doctor Specialty:");
		SpecialtyCompare specialtycompare = new SpecialtyCompare();
		Collections.sort(dList, specialtycompare);
		printDoctors(dList);

	}

	public static void printPatients(List<Patient> pList) {
		for (Patient p : pList) {
			System.out.println(p.getPatientId() + " " + p.getPatientName() + " " + p.getAge());
		}
	}

	public static void printDoctors(List<Doctor> dList) {
		for (Doctor d : dList) {
			System.out.println(d.getDoctorId() + " " + d.getDoctorName() + " " + d.getSpecialty());
		}
	}

}
