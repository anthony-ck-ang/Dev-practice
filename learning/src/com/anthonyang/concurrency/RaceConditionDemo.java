package com.anthonyang.concurrency;

public class RaceConditionDemo {
	
	/*
	 * Race condition ->
	 * Multiple threads entering and manipulating a shared method
	 * -> inaccurate state
	 */
	public static void main(String[] args) {
	   BankAccount task = new BankAccount();
	   task.setBalance(100);
	   
	   Thread jimmyThread = new Thread(task);
	   Thread joelThread = new Thread(task);	   
	   jimmyThread.setName("jimmy");
	   joelThread.setName("joel");
	   jimmyThread.start();
	   joelThread.start();	   
	}
}

class BankAccount implements Runnable {
	private int balance;
	/*synchronized everywhere variable is accessed
	 * Guard same shared mutable var with same lock
	 */
	public synchronized void setBalance(int balance) {
		this.balance = balance;		
	}
	
	public void run() {
		makeWithdrawal(75);
		if (balance < 0) {
			System.out.println("Money overdrawn!!!");
		}
	}	

	/*
	 * Every obj has a lock -> locks are per object not per method
	 * Thread will auto acquire lock when entering synchronized block
	 * x1 thread acquire x1 obj's lock max
	 * Lock will be released after thread exist synchronized block or exception occurs
	 * if lock is unavailable -> thread will wait (Blocked state) to require once available again.
	 * multiple threads can be waiting for the obj lock -> only one will get it as determined by thread scheduler.
	 */
	private synchronized void makeWithdrawal(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
	    } else {
	    	System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
	    }
	}
	
}