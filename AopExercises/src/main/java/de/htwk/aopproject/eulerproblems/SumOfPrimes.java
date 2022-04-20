package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.PrimeFactory;
import de.htwk.aopproject.service.Stopwatch;

public class SumOfPrimes extends Eulerproblem {
	private Stopwatch stopwatch;
	private PrimeFactory primeFactory;

	public SumOfPrimes(Integer id, Stopwatch stopwatch, PrimeFactory primeFactory) {
		super(id, "Eulerproblem 10, Sum of Primes up to 2Mio");
		this.stopwatch = stopwatch;
		this.primeFactory = primeFactory;
	}

	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		long sum = primeFactory.yieldPrimeStream(2000000).asLongStream().sum();
		System.out.println("Die summe der Primzahlen bis 2Mio ist " + sum + ". Der Algorithmus benötigte " + stopwatch.getDurationMillis() + "millisek.");
		return null;
	}

}
