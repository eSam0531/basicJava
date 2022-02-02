package com.hcl.savingsException;

public class InsufficentBalanceException extends Exception{
	public InsufficentBalanceException(String message) {
		System.out.println(message);
	}
	public String toString() {
		return "There are not enough funds in the account." ;
	}
}
