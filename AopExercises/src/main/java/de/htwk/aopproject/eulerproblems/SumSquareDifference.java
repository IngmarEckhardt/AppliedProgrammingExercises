package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.Stopwatch;

public class SumSquareDifference extends Eulerproblem {
	private Stopwatch stopwatch;

	public SumSquareDifference(Integer id, Stopwatch stopwatch) {
		super(id, "Eulerproblem 6, SumOfSquares minus SquareOfSum");
		this.stopwatch = stopwatch;
	}

	@Override
	Object getResultImpl() {
		long result = 0;
		
		result = squareOfSum(100) - sumOfSquares(100);
		System.out.println("Die Differenz beträgt " + result);
		return result;
	}

	private long squareOfSum(int range) {
		
		return ((range*(range+1)/2)*(range*(range+1)/2));
	}

	private long sumOfSquares(int range) {
		
		return ((range)*(range+1)*(2*range+1)/6);
	}

}
