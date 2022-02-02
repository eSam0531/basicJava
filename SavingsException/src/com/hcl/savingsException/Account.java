package com.hcl.savingsException;

public class Account {
	private long balance = 0;

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	/**
	 * 
	 * @param amount the amount to increment
	 */
	public void incrementBalance(long amount) {
		this.balance += amount;
	}
	
	/**
	 * 
	 * @param amount the amount to decrement
	 * @throws InsufficentBalanceException
	 */
	public void decrementBalance(long amount) throws InsufficentBalanceException {
		if(this.balance < amount) {
			throw new InsufficentBalanceException("InsufficentFundsException");
		}
		this.balance -= amount;
	}
	
}
