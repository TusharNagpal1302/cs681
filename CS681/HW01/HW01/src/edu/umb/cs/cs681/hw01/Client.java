package edu.umb.cs.cs681.hw01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Client 
{

	public static void main(String[] args) 
	{

		Observer PieChartObserver = (Observable obs, Object arg) -> 
		{
			if (arg instanceof DJIAEvent) 
			{
				DJIAEvent dJIAEvent = (DJIAEvent) arg;
				System.out.println("PieChartObserver instance of DJIAEvent");
				System.out.println("DJIA:" + dJIAEvent.getDjia());
			} 
			else if (arg instanceof StockEvent) 
			{
				StockEvent stockevent = (StockEvent) arg;
				System.out.println("PieChartObserver instance of StockEvent class.");
				System.out.println(stockevent.getTicker() + "  " + stockevent.getQuote());
			}
		};
		Observer ThreeDObserver = (Observable obs, Object arg) -> 
		{
			if (arg instanceof DJIAEvent) 
			{
				DJIAEvent dJIAEvent = (DJIAEvent) arg;
				System.out.println("ThreeDObserver instance of DJIAEvent");
				System.out.println("DJIA:" + dJIAEvent.getDjia());
			} 
			else if (arg instanceof StockEvent) 
			{
				StockEvent stockevent = (StockEvent) arg;
				System.out.println("ThreeDObserver instance of StockEvent class.");
				System.out.println(stockevent.getTicker() + "  " + stockevent.getQuote());
			}
		};
		Observer TableObserver = (Observable obs, Object arg) -> 
		{
			if (arg instanceof DJIAEvent) 
			{
				DJIAEvent dJIAEvent = (DJIAEvent) arg;
				System.out.println("TableObserver instance of DJIAEvent.");
				System.out.println("DJIA:" + dJIAEvent.getDjia());
			} 
			else if (arg instanceof StockEvent) 
			{
				StockEvent stockevent = (StockEvent) arg;
				System.out.println("TableObserver instance of StockEvent class.");
				System.out.println(stockevent.getTicker() + "  " + stockevent.getQuote());
			}
		};

		DJIAQuoteObservable dJIAQuoteObservable = new DJIAQuoteObservable();
		Set<Float> data = new HashSet<Float>();

		dJIAQuoteObservable.addObservers(PieChartObserver);
		dJIAQuoteObservable.addObservers(TableObserver);
		dJIAQuoteObservable.addObservers(ThreeDObserver);

		dJIAQuoteObservable.changeQuote(1);
		dJIAQuoteObservable.changeQuote(2);
		dJIAQuoteObservable.changeQuote(3);
		data.add((float) 1);
		data.add((float) 2);
		data.add((float) 3);
		
		StockQuoteObservable stockObservable = new StockQuoteObservable();
		HashMap<String, Float> map = new HashMap<>();

		stockObservable.addObservers(PieChartObserver);
		stockObservable.addObservers(TableObserver);
		stockObservable.addObservers(ThreeDObserver);

		stockObservable.changeQuote("Boston", 1);
		stockObservable.changeQuote("Dorchester", 2);
		stockObservable.changeQuote("Quincy", 3);

		map.put("Boston", (float) 1);
		map.put("Dorchester", (float) 2);
		map.put("Quincy", (float) 3);

	}

}