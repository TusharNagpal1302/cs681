package edu.umb.cs.cs681.hw01;

import java.util.HashMap;

public class StockQuoteObservable extends Observable 
{
	private HashMap<String, Float> map;
	
	
	public StockQuoteObservable() 
	{
		map = new HashMap<>();
	}
	public HashMap<String, Float> getMap() 
	{
		return map;
	}

	
	public void changeQuote(String str,float flt) 
	{
		this.map.put(str,flt);
		setChanged();
		notifyObservers(new StockEvent(str,flt));
	}

}