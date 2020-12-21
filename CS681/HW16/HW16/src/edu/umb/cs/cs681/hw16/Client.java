package edu.umb.cs.cs681.hw16;

import java.util.Random;

public class Client {
	public static void main(String[] args) {
		
		System.out.println("StockQuoteObservable");
		
		StockQuoteObservable stockquoteobservable = new StockQuoteObservable();
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("\t Updated Pie Chart Stock Observer:" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("\t Updated Table Stock Observer:" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.println("\t Updated 3D Stock Observer:" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.setQuote();
		stockquoteobservable.notifyObservers(new StockEvent("GM", 800f));
		
		System.out.println("DJAQuoteObservable");
		
		DJIAQuoteObservable DJIAquoteobservable = new DJIAQuoteObservable();
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("\t Updated Pie DJIA Observer:" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("\t Updated Table DJIA Observer:" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.println("\t Updated 3D Chart DJIA Observer:" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.setQuote();
		DJIAquoteobservable.notifyObservers(new DJIAEvent(234.68f));
		
	
		Thread[] sqThreads = new Thread[15];
		Thread[] djiThreads = new Thread[15];
		for(int i = 0; i < 15; i++) {
			Random random = new Random();
			float sqFloatRandom = random.nextFloat()*10f + 200f; 
			float djiFloatRandom = random.nextFloat()*100f + 13000f; 
			sqThreads[i] = new Thread(() ->{
				stockquoteobservable.setQuote();
				stockquoteobservable.notifyObservers(new StockEvent("GM", sqFloatRandom));
				
			});
			sqThreads[i].start();
			djiThreads[i] = new Thread(() ->{
				DJIAquoteobservable.setQuote();
				DJIAquoteobservable.notifyObservers(new DJIAEvent(djiFloatRandom));	
			});
			djiThreads[i].start();
		}
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 15; i++){
			try {
				sqThreads[i].join();
				djiThreads[i].join();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}


class StockEvent {
	private String ticker;
	private float quote;
	public StockEvent(String ticker, float quota) {
		this.ticker = ticker;
		this.quote = quota;
	}
	public String getTicker() {
		return ticker;
	}
	public float getQuote() {
		return quote;
	}
}
class DJIAEvent {
    private float djia;
	
	public float getDjia() {
		return djia;
	}
	public DJIAEvent(float djia)
	{
		this.djia = djia;
	}

	public void setDjia(float djia) {
		this.djia = djia;
	}
}