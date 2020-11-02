package edu.umb.cs.cs681.hw08;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton{

    private static ConcurrentSingleton instance = null;

    private ConcurrentSingleton(){};
    private static ReentrantLock lock = new ReentrantLock();

    public static ConcurrentSingleton getInstance(){
        lock.lock();
        try{
            if(instance==null) {
                instance = new ConcurrentSingleton();
                System.out.println("A new singleton instance is created");
            } else {
                System.out.println("Singleton instance already exists.");
            }
            return instance;

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(() -> {
                            System.out.println("1st thread is created and getIsntance is called to check/create instance");
                            ConcurrentSingleton.getInstance();
                        });
        Thread t2 = new Thread(() -> {
            				System.out.println("2nd thread is created and getIsntance is called to check/create instance");
            				ConcurrentSingleton.getInstance();
        				});

        Thread t3 = new Thread(() -> {
            				System.out.println("3rd thread is created and getIsntance is called to check/create instance ");
            				ConcurrentSingleton.getInstance();
       					});
        	t1.start();
        	t2.start();
        	t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
}
