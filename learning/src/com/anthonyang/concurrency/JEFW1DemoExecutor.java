package com.anthonyang.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class JEFW1DemoExecutor {

	/*
	 * Java executor framework (java.util.concurrent.Executor) run the Runnable
	 * objects without creating new threads every time and mostly re-using the
	 * already created threads. Creating a thread in java is a very expensive
	 * process which includes memory overhead also. So, it’s a good idea if we
	 * can re-use these threads once created, to run our future runnables
	 * 
	 */

	/*
	 * volatile -> thread safe ->used by multiple threads at the same time
	 * without any problem.
	 */
	private static ExecutorService executor = null;
	private static volatile Future<TestOne> taskOneResults = null;
	private static volatile Future taskTwoResults = null;

	public static void main(String[] args) {
		executor = Executors.newFixedThreadPool(2);
		while (true) {
			try {
				checkTasks();
				// executor.shutdown();
				// try {
				// if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				// executor.shutdownNow();
				// }
				// } catch (InterruptedException e) {
				// executor.shutdownNow();
				// }
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println("Caught exception: " + e.getMessage());
			}
		}
	}

	
	@SuppressWarnings("unchecked")
	private static void checkTasks() throws Exception {
		/*
		 * * If any task throws an exception, the application will catch it and
		 * restart the task. If any task runs to completion, the application
		 * will notice and restart the task.
		 */
		if (taskOneResults == null || taskOneResults.isDone() || taskOneResults.isCancelled()) {
			/*
			 * Submits a Runnable task for execution and returns a Future
			 * representing that task. The Future's get method will return null
			 * upon successful completion.
			 */
			
			taskOneResults = (Future<TestOne>) executor.submit(new TestOne());
		}

		if (taskTwoResults == null || taskTwoResults.isDone() || taskTwoResults.isCancelled()) {
			taskTwoResults = executor.submit(new TestTwo());
		}
	}
}

class TestOne implements Runnable {
	public void run() {
		while (true) {
			System.out.println("Executing task one");
			try {
				Thread.sleep(1000);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}
}

class TestTwo implements Runnable {
	public void run() {
		while (true) {
			System.out.println("Executing task two");
			try {
				Thread.sleep(1000);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
