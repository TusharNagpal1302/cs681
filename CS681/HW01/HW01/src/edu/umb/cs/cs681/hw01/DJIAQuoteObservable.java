package edu.umb.cs.cs681.hw01;

import java.util.HashSet;
import java.util.Set;

public class DJIAQuoteObservable extends Observable 
{
	
	private float quote;
	private Set<Float> data = new HashSet<Float>();


	public void changeQuote(float flt)
	{		
		this.quote = flt;
		data.add(flt);
		setChanged();
		notifyObservers(new DJIAEvent(flt));
	}
		
	public Set<Float> getData() 
	{
		return data;
	}

}
