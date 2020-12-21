package edu.umb.cs.cs681.hw15;

import java.util.concurrent.atomic.AtomicBoolean;

public class AdmissionMonitor implements Runnable {
	
	private AdmissionControl control;
	public AtomicBoolean bool = new AtomicBoolean(false);
	
	public AdmissionMonitor(AdmissionControl control) {
		this.control = control;
	}
	
	public void setDone() {
		bool.getAndSet(true);
	}
	
	public void run() {
		while (true) {
			if(bool.get()) {
    			System.out.println("\t Visitor count is halted");
    			break;
			}
			control.visitorsCount();
		}
	}
	
}