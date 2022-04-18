package de.htwk.aopproject.algorithmexercises;

import de.htwk.aopproject.Exercises;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

class Laufzeiten extends ADSExercises {
	double durationAlg1, durationAlg2;
	private long sum, counterOne, counterTwo;
	private int n;
	private UserInput userInput;
	private Stopwatch stopwatch;

	Laufzeiten(int id, UserInput userInput, Stopwatch stopwatch) {
		super(id, "ADS_Uebung1, Laufzeitvergleich zweier Algorithmen");
		this.userInput = userInput;
		this.stopwatch = stopwatch;
		this.n = 0;
	}

	@Override
	Object getResultImpl() {
		counterOne = 0;
		counterTwo = 0;
		
		n = userInput.getInt("Gib das n an, mit dem beide Algorithmen laufen sollen: \n");
		
		String result = "Das Ergebnis des ersten Algorithmus ist: " + algorithmOne() + ", und des zweiten Algorithmus "
				+ algorithmTwo() + " bei einem n von " + n + ". ";
		
		System.out.println(result + "\nDer erste Algorithmus benötigte " + counterOne + " Schritte und " + durationAlg1
				+ " mikrosekunden, der zweite " + counterTwo + " Schritte, und " + durationAlg2 + " mikrosekunden. \n");

		return result;
	}

	private long algorithmOne() {
		stopwatch.startClock();
		sum = 0;
		counterOne += 4;
		for (int i = 1; i <= n; i++) {
			counterOne += 5;
			for (int j = 1; j <= n; j++) {
				sum = sum + 1;
				counterOne += 5;
			}
		}
		durationAlg1 = stopwatch.getDuration();
		return sum;
	}

	private long algorithmTwo() {
		stopwatch.startClock();
		sum = 0;
		counterTwo += 4;
		for (int i = 1; i <= n; i++) {
			counterTwo += 7;
			sum = sum - 1;
			for (int j = 1; j <= i ; j++) {
				sum = sum + 2;
				counterTwo += 5; 				
			}
		}
		durationAlg2 = stopwatch.getDuration();
		return sum;
	}
}