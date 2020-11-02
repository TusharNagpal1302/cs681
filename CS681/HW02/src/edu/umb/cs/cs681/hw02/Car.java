package edu.umb.cs.cs681.hw02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

	private String make, model;
	private int mileage, year;
	private int price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, int price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
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

	public int getDominationCount() {
		return this.dominationCount;
	}

	public static void main(String args[]) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("BMW", "3 series", 30000, 2018, 40000));
		cars.add(new Car("Honda", "Civic", 15000, 2019, 35000));
		cars.add(new Car("Audi", "Q7", 150000, 2015, 50000));
		cars.add(new Car("Toyota", "Camry", 5000, 2020, 45000));
		cars.add(new Car("Toyota", "RAV4", 50000, 2017, 15000));
		cars.add(new Car("Mercedes", "G class", 500, 2020, 65000));

		cars.forEach((Car car) -> car.setDominationCount(cars));

		List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

		List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());

		List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage))
				.collect(Collectors.toList());

		List<Car> sortByDominationCount = cars.stream().sorted(Comparator.comparing(Car::getDominationCount))
				.collect(Collectors.toList());

		System.out.println("\nSort by Price");
		sortByPrice.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getPrice()));

		System.out.println("\nSort by Year");
		sortByYear.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getYear()));

		System.out.println("\nSort by Mileage");
		sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ": " + car.getMileage()));

		System.out.println("\nSort by Domination");
		sortByDominationCount.forEach((Car car) -> System.out.println(car.getMake() + ":" + car.getDominationCount()));
	}
}