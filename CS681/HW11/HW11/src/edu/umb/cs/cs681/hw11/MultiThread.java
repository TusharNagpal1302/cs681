package edu.umb.cs.cs681.hw11;

public class MultiThread implements Runnable {

	  public void run() {
	        System.out.println(ConcurrentSingleton.getInstance());
	        System.out.println("End of Thread " + Thread.currentThread().getName());
	    }

	    public static void main(String[] args) {
	    	
	    	Thread Thread1 = new Thread(new MultiThread());
			Thread Thread2 = new Thread(new MultiThread());
			Thread Thread3 = new Thread(new MultiThread());
			Thread Thread4 = new Thread(new MultiThread());
			Thread Thread5 = new Thread(new MultiThread());
			
			Thread1.start();
			Thread2.start();
			Thread3.start();
			Thread4.start();
			Thread5.start();			
			try {
				Thread1.join();
				Thread2.join();
				Thread3.join();
				Thread4.join();
				Thread5.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
