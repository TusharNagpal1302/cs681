package edu.umb.cs.cs681.hw01;

import java.util.LinkedList;

public abstract class Observable {
	private LinkedList<Observer> observerlist;
	private boolean change = false;
	
	public void addObservers(Observer obs) 
	{
		if (obs == null)
			throw new NullPointerException("Null pointer exception. Cant print null values");
		observerlist.add(obs);
	}
	public void deleteObserver(Observer obs) 
	{
		observerlist.remove(obs);
	}
	public Observable() 
	{
		
		observerlist = new LinkedList<Observer>();
	}
	public boolean hasChanged() 
	{
		return change;
	}
	public  void deleteObservers()
	{
	   observerlist.clear();
	 }	
	protected void setChanged() 
	{
		change = true;
	}
	protected void clearChanged() 
	{
		change = false;
	}
	public void notifyObservers() 
	{
		notifyObservers(null);
	}
	public  int countObservers()
	{
	     return observerlist.size();
	 }

	public void notifyObservers(Object obj) 
	{
		
		if(hasChanged())
		{
			for (int i = 0; i < observerlist.size(); i++)
			{ 		      
				
				//System.out.println("\n");
		          observerlist.get(i).update(this, obj);
		     }  
		}
		clearChanged();
	}

}
