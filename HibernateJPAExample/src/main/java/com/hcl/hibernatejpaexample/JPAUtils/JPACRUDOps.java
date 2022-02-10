package com.hcl.hibernatejpaexample.JPAUtils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hcl.hibernatejpaexample.entity.Student;

public class JPACRUDOps {

	public static void insertEntity(String firstName, String lastName, String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student = new Student(firstName, lastName, email);
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("The student has been added to the Student table.");
	}
	
	public static void findEntity(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Student student = entityManager.find(Student.class, id);
		System.out.println(student.toString());
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static List<Student> getAllEntities(){
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("select s from student s");
		List<Student> students = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return students;
		
	}
	
	public static void updateEntity(Long id, String firstName, String LastName, String email) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Student curStuData = entityManager.find(Student.class, id);
		System.out.println("Current data store for studentID " + id + "is:");
		System.out.println(curStuData.toString());
		
		curStuData.setFirstName(firstName);
		curStuData.setLastName(LastName);
		curStuData.setEmail(email);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public static void removeEntity(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Student student = entityManager.find(Student.class, id);
		System.out.println("Student to be removed: ");
		System.out.println(student.toString());
		
		entityManager.remove(student);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("We student record has been deleted.");
	}
}
