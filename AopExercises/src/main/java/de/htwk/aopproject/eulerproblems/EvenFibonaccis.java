package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.Stopwatch;

class EvenFibonaccis extends Eulerproblem {
	private Stopwatch stopwatch;

	public EvenFibonaccis(Integer id, Stopwatch stopwatch) {
		super(id, "Eulerproblem 2, Summe gerader Fibonacci-Zahlen bis 4Mio");
		this.stopwatch = stopwatch;
	}

	@Override
	Object getResultImpl() {
		
		stopwatch.startClock();
		long sum=0, result, fibo1 = 0, fibo2 = 1;
		
		do {
			result = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = result;
			if (result%2 == 0) {sum += result;}
		} while (result < 4000000);
		
		System.out.println("Die Summe ist " + sum + ". Der Algorithmus brauchte " + stopwatch.getDuration() + "mikrosek.");
		
		stopwatch.startClock();
		long fib3 = 2;
		long fib6 = 0;
		result = 2;
		long summed = 0;
		 
		while (result < 4000000) {
		    summed += result;
		 
		    result = 4*fib3 + fib6;
		    fib6 = fib3;
		    fib3 = result;
		}
		System.out.println("Die Summe ist " + summed + ". Der Algorithmus brauchte " + stopwatch.getDuration() + "mikrosek.");
		
		return null;
	}


}
