package de.aop.htwk.algorithmExercises;

import de.aop.htwk.service.Stopwatch;
import de.aop.htwk.service.UserInput;

class Laufzeiten extends ADSExercises {
	private long durationAlg1, durationAlg2, sum, counterOne, counterTwo;
	private int n;

	Laufzeiten() {
		setId(1);
		setDescription("Laufzeitvergleich zweier Algorithmen");
		this.n = 0;
	}

	@Override
	Object getResult() {
		counterOne = 0;
		counterTwo = 0;
		
		n = UserInput.getInt("Gib das n an, mit dem beide Algorithmen laufen sollen: \n");
		
		String result = "Das Ergebnis des ersten Algorithmus ist: " + algorithmOne() + ", und des zweiten Algorithmus "
				+ algorithmTwo() + " bei einem n von " + n + ". ";
		
		System.out.println(result + "\nDer erste Algorithmus benötigte " + counterOne + " Schritte und " + durationAlg1
				+ " nanosekunden, der zweite " + counterTwo + " Schritte, und " + durationAlg2 + " nanosekunden. \n");

		return result;
	}

	private long algorithmOne() {
		Stopwatch.startClock();
		sum = 0;
		counterOne += 4;
		for (int i = 1; i <= n; i++) {
			counterOne += 5;
			for (int j = 1; j <= n; j++) {
				sum = sum + 1;
				counterOne += 5;
			}
		}
		durationAlg1 = Stopwatch.getDuration();
		return sum;
	}

	private long algorithmTwo() {
		Stopwatch.startClock();
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
		durationAlg2 = Stopwatch.getDuration();
		return sum;
	}
}