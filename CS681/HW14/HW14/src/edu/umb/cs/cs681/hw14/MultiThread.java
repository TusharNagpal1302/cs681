package edu.umb.cs.cs681.hw14;

public class MultiThread {

	public static void main(String[] args) {
		
		ThreadSafeBankAccount account = new ThreadSafeBankAccount();
		WithdrawRunnable withdraw = new WithdrawRunnable(account);
		DepositRunnable deposit= new DepositRunnable(account);
		
		Thread d1  = new Thread(deposit);	Thread w1  = new Thread(withdraw);
		Thread d2  = new Thread(deposit);	Thread w2  = new Thread(withdraw);
		Thread d3  = new Thread(deposit);	Thread w3  = new Thread(withdraw);
		Thread d4  = new Thread(deposit);	Thread w4  = new Thread(withdraw);
		Thread d5  = new Thread(deposit);	Thread w5  = new Thread(withdraw);
		Thread d6  = new Thread(deposit);	Thread w6  = new Thread(withdraw);
		Thread d7  = new Thread(deposit);	Thread w7  = new Thread(withdraw);
		Thread d8  = new Thread(deposit);	Thread w8  = new Thread(withdraw);
		Thread d9  = new Thread(deposit);	Thread w9  = new Thread(withdraw);
		Thread d10 = new Thread(deposit);	Thread w10 = new Thread(withdraw);
		Thread d11 = new Thread(deposit);	Thread w11 = new Thread(withdraw);
		Thread d12 = new Thread(deposit);	Thread w12 = new Thread(withdraw);
		Thread d13 = new Thread(deposit);	Thread w13 = new Thread(withdraw);
		Thread d14 = new Thread(deposit);	Thread w14 = new Thread(withdraw);
		Thread d15 = new Thread(deposit);	Thread w15 = new Thread(withdraw);		
		
		d1.start();			w1.start();		
		d2.start();			w2.start();
		d3.start();			w3.start();		
		d4.start();			w4.start();		
		d5.start();			w5.start();		
		d6.start();			w6.start();		
		d7.start();			w7.start();
		d8.start();			w8.start();
		d9.start();			w9.start();
		d10.start();		w10.start();
		d11.start();		w11.start();
		d12.start();		w12.start();
		d13.start();		w13.start();
		d14.start();		w14.start();
		d15.start();		w15.start();		
		
		deposit.setDone();
		withdraw.setDone();
		
		d1.interrupt();		w1.interrupt();
		d2.interrupt();		w2.interrupt();
		d3.interrupt();		w3.interrupt();
		d4.interrupt();		w4.interrupt();
		d5.interrupt();		w5.interrupt();
		d6.interrupt();		w6.interrupt();
		d7.interrupt();		w7.interrupt();
		d8.interrupt();		w8.interrupt();
		d9.interrupt();		w9.interrupt();
		d10.interrupt();	w10.interrupt();
		d11.interrupt();	w11.interrupt();
		d12.interrupt();	w12.interrupt();
		d13.interrupt();	w13.interrupt();
		d14.interrupt();	w14.interrupt();
		d15.interrupt();	w15.interrupt();		
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
			d6.join();
			d7.join();
			d8.join();
			d9.join();
			d10.join();
			d11.join();
			d12.join();
			d13.join();
			d14.join();
			d15.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 		
	}
}