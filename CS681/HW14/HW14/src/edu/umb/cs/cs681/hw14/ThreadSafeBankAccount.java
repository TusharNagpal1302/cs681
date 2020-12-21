package edu.umb.cs.cs681.hw14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount {
	
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();
	
	public ThreadSafeBankAccount() {
		super();
	}

	public void withdraw(double amount){
		
		lock.lock();		
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Balance	: " + balance);
			while (balance <= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t Balance is low!	: Await Withdraw");
					sufficientFundsCondition.await();
				}
				catch (InterruptedException e) {
					return; 
				}
			}
			
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + "\t Updated Balance after withdrawal	: " + balance);
			belowUpperLimitFundsCondition.signalAll();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void deposit(double amount){
		
		lock.lock();
		
		try {
			System.out.println(Thread.currentThread().getName() + "\t Current Balance	: " + balance);
			while (balance >= 300) {
				try {
					System.out.println(Thread.currentThread().getName() + "\t Balance exceeded limit!	: Await Deposit");
					belowUpperLimitFundsCondition.await();
				}
				catch (InterruptedException e) {
					return; 
				}
			}
			
			balance += amount;
			System.out.println(Thread.currentThread().getName() + "\t Updated Balance after deposit	: " + balance);
			sufficientFundsCondition.signalAll();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}