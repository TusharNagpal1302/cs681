package edu.umb.cs.cs681.hw18;

public class StockEvent {
	private String ticker;
	private float quote;

	public StockEvent(String tickers, float quote) {
		this.ticker = tickers;
		this.quote = quote;
	}

	public String getTicker() {
		return ticker;
	}

	public float getQuote() {
		return quote;
	}
}