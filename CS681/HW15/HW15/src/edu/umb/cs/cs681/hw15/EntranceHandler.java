package edu.umb.cs.cs681.hw15;

import java.util.concurrent.atomic.AtomicBoolean;

public class EntranceHandler implements Runnable {
	
	private AdmissionControl control;
	public AtomicBoolean bool = new AtomicBoolean(false);
	
	public EntranceHandler(AdmissionControl control) {
		this.control = control;
	}
	
	public void setDone() {
		bool.getAndSet(true);
	}
	
	@Override
	public void run() {
		while (true) {
			if(bool.get()) {
    			System.out.println("\t Entrance is Terminated");
    			break;
			}
			control.enter();
		}
	}
	
}