package com.anthonyang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutorServiceExample {

	private static void executorServiceWithLambda() {
		/*
		 * Factory methods for creating different kinds of executor services.
		 */
		ExecutorService executor = Executors.newSingleThreadExecutor();
		/*
		 * Submits a Runnable task for execution and returns a Future
		 * representing that task. The Future's get method will return null upon
		 * successful completion.
		 */
		executor.submit(() -> {
			//some tasks...
			System.out.println(Thread.currentThread().getName());
		});
		
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}
	}

	private static void executorService() {
		// ref: https://dzone.com/articles/the-executor-framework

		// Create a fixed size thread pool of 5 worker threads.
		ExecutorService executor = Executors.newFixedThreadPool(5);

		/*
		 * Submit 10 jobs to the pool Pool size is 5 -> it will start working on
		 * 5 jobs and other jobs will be in wait state
		 * 
		 * Once job is finished, another job from the wait queue will be picked
		 * up by worker thread and will get executed.
		 */
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i); // using Threads
			executor.execute(worker);
		}
		// executor.shutdown(); // Initiates an orderly shutdown in which
		// // previously submitted tasks are executed, but
		// // no new tasks will be accepted.
		//
		// while (!executor.isTerminated()) {
		// //keep looping until true
		// }
		executor.shutdown();
		try {
			if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		System.out.println("Finished all threads");
	}

	public static void main(String[] args) {
		//executorService();
		executorServiceWithLambda();
	}
}

class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		// processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}