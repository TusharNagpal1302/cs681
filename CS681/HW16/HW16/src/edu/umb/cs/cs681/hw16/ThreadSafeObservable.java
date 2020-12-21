package edu.umb.cs.cs681.hw16;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicBoolean;


public class ThreadSafeObservable {
	
	private LinkedList<ThreadSafeObserver> observers;
	
	private AtomicBoolean changed;
	
	private ReentrantLock lock = new ReentrantLock();
	
	public ThreadSafeObservable() {
		observers = new LinkedList<ThreadSafeObserver>();
		changed = new AtomicBoolean();
	}
	
	public void addObserver(ThreadSafeObserver o) {
		if(o == null) throw new NullPointerException();
		lock.lock();
		
		try {
			observers.add(o);
		} finally {
			lock.unlock();
		}
	}
	
	public void deleteObserver(ThreadSafeObserver o) {
		lock.lock();
		try {
			if(observers.remove(o)) {
				System.out.println("Observer is removed");
			}else {
				System.out.println("Observer does not exist");
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void deleteObservers() {
		lock.lock();
		try {
			observers.clear();
		} finally {
			lock.unlock();
		}	
	}
	
	public int countObservers() {
		int tmp = 0;
		lock.lock();
		try {
			tmp = observers.size();
		} finally {
			lock.unlock();
		}
		return tmp;
	}
	
	protected void setChanged() {
		changed.set(true);
	}
	
	protected void clearChanged() {
		changed.set(false);
	}
	
	public boolean hasChanged() {
		return changed.get();
	}
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	public void notifyObservers(Object obj) {
		if(!changed.get()) {
			return;
		}
		lock.lock();
		try {
			observers.forEach(n -> n.update(this, obj));
		} finally {
			lock.unlock();
		}
		clearChanged();
	}
}