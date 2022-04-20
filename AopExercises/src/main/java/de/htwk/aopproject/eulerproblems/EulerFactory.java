package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.PrimeFactory;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

public class EulerFactory extends Factory {

	private UserInput userInput;
	private Stopwatch stopwatch;
	private PrimeFactory primeFactory;
	private int counter;

	public EulerFactory (UserInput userInput, Stopwatch stopwatch, PrimeFactory primeFactory) {
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.primeFactory = primeFactory;
		this.counter = 0;
	}

	@Override
	public Eulerproblem getInstance() {
		counter++;
		switch (counter) {
		case 1:
			return new SumOfMultiples(counter, stopwatch);
		case 2:
			return new EvenFibonaccis(counter, stopwatch);
		case 3:
			return new PrimeFactor(counter, stopwatch, primeFactory);
		case 4:
			return new LargestPalindrom(counter, stopwatch);
		case 5:
			return new SmallestMultiple(counter, stopwatch);
		case 6:
			return new SumSquareDifference(counter, stopwatch);
		case 7:
			return new PrimeNumberTenthousandOne(counter, stopwatch, primeFactory);
		case 8:
			return new LargestProduct(counter, stopwatch);
		case 9:
			return new SumOfPrimes(counter, stopwatch, primeFactory);
		case 10:
			return new LargestProductInGrid(counter, stopwatch);
				
		default:
			counter--;
			return null;
		}
	}

}