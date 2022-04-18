package de.htwk.aopproject.algorithmexercises;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

public class ADSFactory extends Factory {
	
	private UserInput userInput;
	private Stopwatch stopwatch;
	private int counter;
	
	public ADSFactory (UserInput userInput, Stopwatch stopwatch) {
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.counter = 0;
	}
	
	public ADSExercises getInstance() {
		counter++;
		switch (counter) {
		case 1:
			return new Laufzeiten(counter, userInput, stopwatch);
		default:
			counter--;
			return null;
		}
	}
	
}
