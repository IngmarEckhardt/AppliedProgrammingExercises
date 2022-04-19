package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.Stopwatch;

public class SmallestMultiple extends Eulerproblem {
	private Stopwatch stopwatch;

	public SmallestMultiple(Integer id, Stopwatch stopwatch) {
		super(id, "Eulerproblem 5, the smallest Multiple");
		this.stopwatch = stopwatch;
	}

	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		int result = 0;
		for (int i = 200; i < Integer.MAX_VALUE; i++) {
			if (i%11 == 0 && i % 12 == 0 && i % 13 == 0 && i % 14 == 0 && i % 15 == 0 && i % 16 == 0 && i % 17 == 0 && i % 18 == 0 && i % 19 == 0 && i % 20 == 0) {
				result = i;
				break;
			} else {continue;}
		}
		System.out.println("the smallest Multiple is " + result + ". Der Algorithmus brauchte " + stopwatch.getDurationMillis() + "milliosek.");
		return result;
	}

}
