package edu.umb.cs.cs681.hw17;

public class Client {
    public static void main(String[] args) {
		
		Thread[] threads = new Thread[15];
		RequestHandler[] requestHandlers = new RequestHandler[15];


		for (int count = 0; count < 15; count++) {
			System.out.println("Start of thread " + count);
			requestHandlers[count] = new RequestHandler(count);
			threads[count] = new Thread(requestHandlers[count]);
			threads[count].start();
		}

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " " + e);
		}
		for(int count = 0; count < 15; count++) {
			requestHandlers[count].setDone();
			threads[count].interrupt();
			try {
				threads[count].join();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
