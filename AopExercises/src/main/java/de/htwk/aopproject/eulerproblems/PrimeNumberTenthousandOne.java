package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.PrimeFactory;
import de.htwk.aopproject.service.Stopwatch;

public class PrimeNumberTenthousandOne extends Eulerproblem {
	private Stopwatch stopwatch;
	private PrimeFactory primeFactory;

	public PrimeNumberTenthousandOne(Integer id, Stopwatch stopwatch, PrimeFactory primeFactory) {
		super(id, "Eulerproblem 7, the 100001st prime");
		this.stopwatch = stopwatch;
		this.primeFactory = primeFactory;
	}

	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		int prime = primeFactory.yieldPrimeStream(200000).boxed().limit(10001L).reduce((first, second) -> second).orElse(null);
		System.out.println("Die 10.001ste Primzahl ist " + prime + ". Der Algorithmus brauchte " + stopwatch.getDuration() + "mikrosek.");
		
		return null;
	}

}
