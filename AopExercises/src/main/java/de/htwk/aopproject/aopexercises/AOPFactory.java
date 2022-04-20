package de.htwk.aopproject.aopexercises;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.Calculator;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

public class AOPFactory extends Factory {
	
	private UserInput userInput;
	private Stopwatch stopwatch;
	private Calculator calculator;
	private int counter;
	
	public AOPFactory (UserInput userInput, Stopwatch stopwatch, Calculator calculator) {
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.calculator = calculator;
		this.counter = 0;
	}
	
	public AOPExercises getInstance() {
		counter++;
		switch (counter) {
		case 1:
			return new RomanNumbers(counter, userInput);
		case 2:
			return new DynamicDeviation(counter, calculator);
		default:
			counter--;
			return null;
		}
	}
	
}