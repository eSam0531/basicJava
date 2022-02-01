// Solution to HackerRank Mars Exploration problem
/*
 * Space explore sends SOS message to Earth for help but some letters are
 * altered by cosmic radiation during transmission. Given string s,
 * determine how many letters of the SOS message have been changed by radiation.
 * 
 * Ex - msg = "SOSTOT"--> result: 2
 * 			expected: SOSSOS
 * 			received: SOSTOT
 * 						 x x --> 2 altered chars
 * 		msg = "SOSSPSSQSSOR --> result: 3
 * 			expected: SOSSOSSOSSOS
 * 			received: SOSSPSSQSSOR
 * 						  x  x   x --> 3 altered chars
 */
package simpleJava;

import java.util.Scanner;

public class SimpleJava {

	public static void main(String[] args) {
		System.out.println("My first Maven project!");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a message to be evaluated:");
		String msg = keyboard.nextLine();
		keyboard.close();
		
		int result = marsExploration(msg);
		
		System.out.print("Changed Characters:" + result);

	}

	private static int marsExploration(String msg) {
		String pattern = "SOS";
		int pointer = 0;
		int chgChar = 0;
		
		while(msg.length() > pointer) {
			String sub = msg.substring(pointer, pointer+3);
			if(!(sub.equals(pattern))) {
				for(int i = 0; i < sub.length(); i++) {
					if(!(sub.charAt(i) == pattern.charAt(i))) {
						chgChar +=1;
					}
				}
			}
			pointer +=3;
		}
		
		return chgChar;
	}

}
