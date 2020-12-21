package edu.umb.cs.cs681.hw14;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable{
	
	private ThreadSafeBankAccount account = null;
	public AtomicBoolean done = new AtomicBoolean(false);
		
	public WithdrawRunnable(ThreadSafeBankAccount account) {
		this.account = account;
	}
	
	public void setDone() {
		done.getAndSet(true);
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			if(done.get()) {
    			System.out.println(Thread.currentThread().getName() +"\t Successfuly withdrew money!");
    			break;
			}
			
			System.out.println(Thread.currentThread().getName() +"\t Withdrawing money!");
			account.withdraw(200);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}
}