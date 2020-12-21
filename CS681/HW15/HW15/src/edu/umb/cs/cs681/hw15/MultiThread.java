package edu.umb.cs.cs681.hw15;

public class MultiThread {

	public static void main(String[] args) {
		
		AdmissionControl admission = new AdmissionControl();
		EntranceHandler entrance = new EntranceHandler(admission);
		ExitHandler exit_handler = new ExitHandler(admission);
		AdmissionMonitor monitor = new AdmissionMonitor(admission);
		
		Thread ThreadEntrance = new Thread(entrance);
		Thread ThreadExit = new Thread(exit_handler);
		Thread ThreadMonitor = new Thread(monitor);
		
		ThreadEntrance.start();
		ThreadExit.start();
		ThreadMonitor.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		entrance.setDone();
		exit_handler.setDone();
		monitor.setDone();
		
		ThreadEntrance.interrupt();
		ThreadExit.interrupt();
		ThreadMonitor.interrupt();
		
		try {
			ThreadEntrance.join();
			ThreadExit.join();
			ThreadMonitor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}