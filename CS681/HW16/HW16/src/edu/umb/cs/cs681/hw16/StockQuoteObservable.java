package edu.umb.cs.cs681.hw16;

public class StockQuoteObservable extends ThreadSafeObservable {
	public void setQuote() {
		this.setChanged();
	}
}