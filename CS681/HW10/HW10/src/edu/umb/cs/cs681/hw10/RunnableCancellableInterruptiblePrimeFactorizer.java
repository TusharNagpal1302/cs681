package edu.umb.cs.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}
	
	public void setDone(){
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}

	public void generatePrimeFactors(){
		long divisor = from;
		while( dividend != 1 && divisor <= to ){
			lock.lock();
			try{
				if (done){
					System.out.println("Generate prime factors method ended.");
					this.factors.clear();
					break;
				}
				if( divisor > 2 && isEven(divisor)) {
					divisor++;
					continue;
				}
				if(dividend % divisor == 0) {
					factors.add(divisor);
					System.out.println(divisor);
					dividend /= divisor;
				}else {
					if(divisor==2){ divisor++; }
					else{ divisor += 2; }
				}
			} finally {
				lock.unlock();
			}

			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(2500,2, 200);
		Thread thread1 = new Thread(gen);
		thread1.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		gen.setDone();
		thread1.interrupt();

		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n" + gen.getPrimeFactors() + " are the prime factors.");
		
		
	}

}
