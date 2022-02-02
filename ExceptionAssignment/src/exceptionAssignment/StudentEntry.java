package exceptionAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentEntry {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		List<Student> students = new ArrayList<>();
		System.out.print("Please enter the number of students to add: ");
		int qty = keyboard.nextInt();
		keyboard.nextLine();
		
		try {
			while(qty > 0) {
				System.out.println("StudentID:");
				String id = keyboard.nextLine();
				System.out.println("Student Name:");
				String name = keyboard.nextLine();
				System.out.println("Score:");
				int score = keyboard.nextInt();
				if(score < 0 || score > 100) {
					throw new InvalidScore();
				}
				students.add(new Student(id,name,score));
				qty--;
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Exception : "+ e);
		}
		catch (InvalidScore e) {
			System.out.println("Exception : "+ e);
		}
		finally {
			keyboard.close();
		}
		
		
	}

}
