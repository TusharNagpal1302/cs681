package edu.umb.cs.cs681.hw03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Car> usedCars = new ArrayList<Car>();//String name, int year,  float mileage, int price
		usedCars.add(new Car("Audi(A)",2008,4100f,5000));
		usedCars.add(new Car("Jaguar(B)",2009,5100f,8000));
		usedCars.add(new Car("Volkswagen(C)",2010,1100f,12000));
		usedCars.add(new Car("Mercedes(D)",2011,3100f,8000));
		usedCars.add(new Car("BMW(E)",2012,2100f,8000));
		System.out.println("Name -- Year --  Mileage -- Price");
		for(Car c: usedCars){
			System.out.println(c+" -- "+c.getYear()+" --  "+c.getMileage()+" -- "+c.getPrice());
		}
		System.out.println("------Sorting results------");
		List<Car> carsPrice =
				usedCars.stream()
				.sorted( Comparator.comparing((Car car)-> car.getPrice()) )
				.collect(Collectors.toList());
		System.out.println("PriceComparator using stream: "+carsPrice);
		System.out.println("----------------------------------------------------------------------------------------");
		
		//sort based on mileage
		List<Car> carsMileage =
				usedCars.stream()
				.sorted( Comparator.comparing((Car car)-> car.getMileage()) )
				.collect(Collectors.toList());
		System.out.println("MileageComparator using stream: "+carsMileage);
		System.out.println("----------------------------------------------------------------------------------------");
		
		//sort based on year
		List<Car> carsYear =
				usedCars.stream()
				.sorted( Comparator.comparing((Car car)-> car.getYear()) )
				.collect(Collectors.toList());
		System.out.println("YearComparator using stream: "+carsYear);
		System.out.println("----------------------------------------------------------------------------------------");
		
		// sort based on domination count
		for(Car c: usedCars){
			 c.setCars(usedCars);
			}
		
		List<Car> carsPare =
				usedCars.stream()
				.sorted( Comparator.comparing((Car car)-> car.getDominationCount()) )
				.collect(Collectors.toList());
		System.out.println("ParetoComparator/Domination using stream: "+carsPare);
		System.out.println("----------------------------------------------------------------------------------------");
		
	}
}
