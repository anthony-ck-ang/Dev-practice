package com.anthonyang.concurrency;

import java.util.concurrent.TimeUnit;

public class FirstThread {

	private static void firstThread() {
		Task task = new Task();
		Thread thread = new Thread(task); // add task to thread
		thread.start();// Causes this thread to begin execution

		try {
			// Thread.sleep(3000);
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		firstThread();
		
		Thread myThread = new FirstThread2();
		myThread.start();
		System.out.println("Inside main ... main thread");
	}

}

/*
 * Runnable interface should be implemented by any class whose instances are
 * intended to be executed by a thread.
 */
class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run... run some task...");

	}

}

//another way, Thread also implements Runnable
class FirstThread2 extends Thread {

	public void run() {
		System.out.println("Inside run ...");
		go();
	}

	private void go() {
		System.out.println("Inside go ...");
		more();
	}

	private void more() {
		System.out.println("Inside more ...");
	}

}