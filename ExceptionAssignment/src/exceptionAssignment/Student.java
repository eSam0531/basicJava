package exceptionAssignment;

public class Student {
	private String studentID;
	private String studentName;
	private int score;
	
	public Student(String studentID, String studentName, int score) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.score = score;
	}

	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
}
