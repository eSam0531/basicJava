package com.hcl.nameassignment;

public class NameLengthException extends Exception{
	
	public NameLengthException(String message) {
		System.out.println(message);
	}
	public String toString() {
		return "Name must be between 10 to 15 characters in length.(including spaces)" ;
	}
}
