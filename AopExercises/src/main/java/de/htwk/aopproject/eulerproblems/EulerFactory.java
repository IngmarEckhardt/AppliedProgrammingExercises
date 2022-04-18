package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

public class EulerFactory extends Factory {

	private UserInput userInput;
	private Stopwatch stopwatch;
	private int counter;

	public EulerFactory (UserInput userInput, Stopwatch stopwatch) {
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.counter = 0;
	}

	@Override
	public Eulerproblem getInstance() {
		counter++;
		switch (counter) {
		case 1:
			return new SumOfMultiples(counter, userInput, stopwatch);
		case 2:
			return new EvenFibonaccis(counter, userInput, stopwatch);
		default:
			counter--;
			return null;
		}
	}

}