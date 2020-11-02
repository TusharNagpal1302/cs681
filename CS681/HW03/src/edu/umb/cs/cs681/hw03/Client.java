package edu.umb.cs.cs681.hw03;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		ArrayList<Car> usedCars = new ArrayList<Car>();
		
		usedCars.add(new Car(54000,2019,10350,"BMW i3"));
		usedCars.add(new Car(8000,2012,175000,"Honda Accord"));
		usedCars.add(new Car(3000,2018,200000,"Honda Civic"));
		usedCars.add(new Car(23000,2017,55000,"Toyota RAV4"));
		usedCars.add(new Car(68000,2016,45000,"Tesla Model X"));
		usedCars.add(new Car(22000,2015,75000,"Audi A4"));
		usedCars.add(new Car(14000,2013,89000,"Mercedes A class"));
		usedCars.add(new Car(100000,2015,20000,"Ford Mustang GT"));
		usedCars.add(new Car(4400,1995,100300,"Volvo s60"));
		usedCars.add(new Car(80000,2019,15000,"Tesla Cybertruck"));
		usedCars.add(new Car(99000,2020,1,"Hummer EV"));
	
		System.out.println("Below is the list of prices of all the cars:");
		usedCars.forEach( (Car car)->System.out.println(car.getPrice()));
								
				Integer Count = usedCars.stream().map( (Car car)-> car.getPrice() )
						. reduce(0, (result, carPrice)->{return ++result;} );
				System.out.println("Total number of cars: " + Count);

		Integer maximumPrice = usedCars.stream().map( (Car car)-> car.getPrice() )
				. reduce(0, (result, carPrice)->{
							if(result==0) return carPrice;
							else if(carPrice < result) return result;
							else return carPrice;} );
	
		System.out.println("Price of the most expensive car is : $" + maximumPrice);
		
		Integer minimumPrice = usedCars.stream().map( (Car car)-> car.getPrice() )
												. reduce(0, (result, carPrice)->{
															if(result==0) return carPrice;
															else if(carPrice < result) return carPrice;
															else return result;} );
		System.out.println("Price of the cheapest car is : $" + minimumPrice);		
	}
}