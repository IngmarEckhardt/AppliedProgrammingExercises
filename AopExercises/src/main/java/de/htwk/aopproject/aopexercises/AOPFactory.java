package de.htwk.aopproject.aopexercises;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

public class AOPFactory extends Factory {
	
	private UserInput userInput;
	private Stopwatch stopwatch;
	private int counter;
	
	public AOPFactory (UserInput userInput, Stopwatch stopwatch) {
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.counter = 0;
	}
	
	public AOPExercises getInstance() {
		counter++;
		switch (counter) {
		case 1:
			return new RomanNumbers(counter, userInput, stopwatch);
		default:
			counter--;
			return null;
		}
	}
	
}