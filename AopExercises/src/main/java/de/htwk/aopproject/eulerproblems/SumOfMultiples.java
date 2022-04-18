package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

class SumOfMultiples extends Eulerproblem {
	private UserInput userInput;
	private Stopwatch stopwatch;
	
	public SumOfMultiples(Integer id, UserInput userInput, Stopwatch stopwatch) {
		super(id, "Eulerproblem 1, Summe der Produkte von 3 und 5 bis 1000");
		this.userInput = userInput;
		this.stopwatch = stopwatch;
	}
	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		int sum = 0;
		for (int i = 1; i < 334; i++) {
				sum += i*3;
		}
		for (int j = 1; j < 200; j++) {
			if (j%3 == 0) {continue;}
			sum += j*5;
		}
		System.out.println("Der Algorithmus benötigte " + stopwatch.getDuration() + "mikrosekunden");
		System.out.println("Die summe ist " + sum);
		
		stopwatch.startClock();
		sum = 0;
		for (int i = 1; i < 1000; i++) {
			if ((i%3 == 0) || (i%5 == 0)) {sum += i;}
		}
		System.out.println("Der Algorithmus benötigte " + stopwatch.getDuration() + "mikrosekunden");
		System.out.println("Die summe ist " + sum);
		
		stopwatch.startClock();
		sum = 0;
		sum = SumDivisbleBy(3,999)+SumDivisbleBy(5,999)-SumDivisbleBy(15,999);
		System.out.println("Der Algorithmus benötigte " + stopwatch.getDuration() + "mikrosekunden");
		System.out.println("Die summe ist " + sum);
		 
		return null;
	}
	private int SumDivisbleBy(int n, int p){
		return n*(p/n)*((p/n)+1)/2;
	}
}
