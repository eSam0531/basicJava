package exceptionAssignment; 

public class InvalidScoreException extends Exception {
	public InvalidScoreException() {
		System.out.println("User defined Exception thrown");
	}
	public String toString() {
		return "MyException Object : Score must be between 0 and 100." ;
	}
}
