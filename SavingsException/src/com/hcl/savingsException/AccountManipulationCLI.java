/*
 * Write a Java program to handle exception handling mechanism through 
 * user-oriented exception handling let's say you deposit 600 $ 
 * in favor saving account then you withdraw 100 $ from your account, 
 * now you had 500 $ remining with you, but if you want to withdraw 
 * 600 $ again ,then your program should throw InSufficentBalance Exception
 */

package com.hcl.savingsException;

import java.util.Scanner;

public class AccountManipulationCLI {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Account acct = new Account();
		boolean exit = false;
		String opt1 = "1. Make a deposit";
		String opt2 = "2. Make a withdrawl";
		String opt3 = "3. Check balance";
		String opt4 = "4. Exit";
		long amount = 0;

		do {
			System.out.println("What would you like to do?\n" 
					+ opt1 + "\n" + opt2 + "\n" + opt3 + "\n" + opt4 + "\n");
			int opt = kb.nextInt();
			kb.nextLine();

			switch (opt) {
			case 1:
				System.out.println("How much would you like to deposit?");
				amount = kb.nextLong();
				acct.incrementBalance(amount);
				break;
			case 2:
				boolean sufficient = false;
				while (!sufficient) {
					System.out.println("How much would you like to withdraw?");
					amount = kb.nextLong();
					try {
						acct.decrementBalance(amount);
						sufficient = true;
					} catch (InsufficentBalanceException e) {
						System.out.println(e);
						System.out.println("Please enter a different amount.");
					}
				}
				break;
			case 3:
				System.out.println("Current balance is: " + acct.getBalance());
				break;
			case 4:
				System.out.println("Good-bye");
				exit = true;
				break;
			default:
				System.out.println("Invalid option please try again.");
				break;
			}
		} while (!exit);
		
		kb.close();

	}

}
