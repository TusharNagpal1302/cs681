package edu.umb.cs.cs681.hw19;

import java.util.ArrayList;
import java.util.List;

public class Client {
public static void main(String[] args) {
	
	List<Car> cars = new ArrayList<>();
	
	cars.add(new Car(1973, "Honda", "Civic", 12700, 2013, 7000));
	cars.add(new Car(2032, "Audi", "A6", 40000, 2018, 12000));
	cars.add(new Car(3086, "Toyota", "Corola", 30000, 2015, 5000));
	cars.add(new Car(4429, "BMW", "3 series", 2000, 2020, 28000));
	cars.add(new Car(5098, "Honda", "City", 10000, 2017, 9000));
	cars.add(new Car(6204, "Toyota", "RAV4", 52000, 2018, 10000));
	cars.add(new Car(6204, "Toyota", "RAV4", 32000, 2019, 100000));

	cars.forEach((Car car) -> car.setDominationCount(cars));
	
	Integer colorcode = cars
						 .stream()
		                 .parallel()
		                 .map((Car car) -> car.getColorCode())
		                 .reduce(0, (result, carColorCode) -> result += carColorCode,
		                         (finalResult, intermediateResult) -> finalResult + intermediateResult);

    System.out.println("Sum Of Car Color Code\t: " + colorcode);

	Integer Mileage = cars
						 .stream()
						 .parallel()
						 .map((Car car) -> car.getMileage())
						 .reduce(0, (result, carMileage) -> {
							 if (result == 0)				return carMileage;
							 else if (carMileage < result)	return carMileage;
							 else							return result;}	);

	System.out.println("Minimum Car Mileage\t: " + Mileage);

	Integer Price = cars
					   .stream()	
					   .parallel()
					   .map((Car car) -> car.getPrice())
					   .reduce(0, (result, carPrice) -> {
						   	if (result == 0)			return carPrice;
							else if (carPrice > result)	return carPrice;
							else						return result;}	);

	System.out.println("Maximum Car Price \t: " + Price);

	
	Integer numberOfModel = cars.stream()
			.parallel()
			.map((Car car) -> car.getModel())
			.distinct()
			.reduce(0, (result, model) -> {
				return ++result;
			}, (finalResult,intermediateResult) -> {
				return finalResult+intermediateResult;
			});
	
	System.out.println("The Number of Models\t: " + numberOfModel);
	
}
}