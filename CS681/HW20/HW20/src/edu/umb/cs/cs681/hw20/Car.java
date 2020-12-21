package edu.umb.cs.cs681.hw20;

import java.util.ArrayList;

public class Car {

	private int price;
	private String name;
	private String model;

	public Car( String model, String name,int price) {
		this.model = model;
		this.price=price;
		this.name=name;
	}

	public int getPrice(){
		return this.price;
	}

	public String getName() {
		return this.name;
	}
	
	public String getModel() {
		return this.model;
	}


	public static void main(String args[]) {

		Car honda=new Car("Honda","Civic",6000);
		Car toyota=new Car("Toyota","RAV4",15000);
		Car audi=new Car("Audi","A4",30000);
		ArrayList<Car> cars=new ArrayList<Car>();

		cars.add(honda);
		cars.add(toyota);
		cars.add(audi);

		//minPrice of cars
		Integer minprice = cars.stream().parallel().map((Car car)-> car.getPrice()).reduce(0, (result, carPrice)->{
			if(result==0) 
				return carPrice;
			else if(carPrice < result) 
				return carPrice; 
			return result;});

		//maxPrice of cars
		Integer maxprice = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(0,(result, carPrice)->{
			if(result==0)
				return carPrice;
			else if(carPrice > result)
				return carPrice;
			return result;});

		//count of cars
		Integer count = cars.stream().parallel().map((Car car) -> car.getPrice()).reduce(1, (result, carPrice)->{
			return ++result;});
		
		//count using 3rd version of reduce() and parallel streams on getModel()
		Integer newCount = cars.stream().parallel().map((Car car) -> car.getModel()).reduce(0, 
				(result, carModel)-> ++result , (finalResult, intermediateResult) -> finalResult + intermediateResult);

		System.out.println("Total Count: " + count );;
		System.out.println("Min-Price: " + minprice);
		System.out.println("Max-Price: " + maxprice);
		System.out.println("Find count using 3rd version of reduce() and parallel streams on getModel()");
		System.out.println("Total Count in 3rd version: " + newCount );
		
	}
}