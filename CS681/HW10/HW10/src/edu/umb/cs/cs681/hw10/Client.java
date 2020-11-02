package edu.umb.cs.cs681.hw10;



public class Client {


	public static void main(String[] args) {
		PrimeFactorizer fac = new PrimeFactorizer(42);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 42 are: " + fac.getPrimeFactors());
		
		fac = new PrimeFactorizer(103);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 103 are: " + fac.getPrimeFactors());
		
		fac = new PrimeFactorizer(67);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 67 are: " + fac.getPrimeFactors());
		
		fac = new PrimeFactorizer(1274);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 1274 are: " + fac.getPrimeFactors());
		
		fac = new PrimeFactorizer(375);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 375 are: " + fac.getPrimeFactors());
		
		fac = new PrimeFactorizer(964);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 964 are: " + fac.getPrimeFactors());
	}
	
	}




