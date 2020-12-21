package edu.umb.cs.cs681.hw18;

import java.util.concurrent.locks.ReentrantLock;

public class DJIAQuoteObservable extends Observable {
	
	private ReentrantLock locks = new ReentrantLock();

	public void changeQuote(float quote) {
		locks.lock();
		this.setChanged();
		this.notifyObservers(new DJIAEvent(quote));
		locks.unlock();
	}
	
	public void setQuote(float quote) {	
		locks.lock();
		this.setChanged();
		notifyObservers(new DJIAEvent(quote));
		locks.unlock();
	}

}