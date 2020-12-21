package edu.umb.cs.cs681.hw19;

import java.util.List;

public class Car {
	
	private int colorCode;
	
	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(int colorCode, String make, String model, int mileage, int year, float price) {
		this.colorCode = colorCode;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public int getColorCode() {
		return this.colorCode;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return (int) price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(List<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--; 	
	}
}