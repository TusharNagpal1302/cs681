package edu.umb.cs.cs681.hw12;

public class MultiThread implements Runnable {

    public void run() {
    	
        Customer customer = new Customer(new Address("Dorchester Ave", "Boston", "MA", 02126));
        System.out.println("Address is \t:	"+ customer.getAddress());
        customer.setAddress(customer.getAddress().change("Santa Monica", "Los Angeles", "CA", 90009));
        System.out.println("Address changed to	\t:	"+ customer.getAddress());
        customer.setAddress(new Address("Lake View", "Chicago", "IL", 40934));
        System.out.println("New address is set to	\t:	"+ customer.getAddress());
    }

    public static void main(String[] args) {
    	
    	Thread Thread1 = new Thread(new MultiThread());
		Thread Thread2 = new Thread(new MultiThread());
		Thread Thread3 = new Thread(new MultiThread());
		Thread Thread4 = new Thread(new MultiThread());
		
		Thread1.start();
		Thread2.start();
		Thread3.start();
		Thread4.start();
		
		try {
			Thread1.join();
			Thread2.join();
			Thread3.join();
			Thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }
}