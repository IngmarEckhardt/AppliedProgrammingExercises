package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.service.Stopwatch;

public class LargestPalindrom extends Eulerproblem {
	private Stopwatch stopwatch;

	public LargestPalindrom(Integer id, Stopwatch stopwatch) {
		super(id, "Eulerproblem 4, the largest Palindrom");
		this.stopwatch = stopwatch;
	}

	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		int factor1, factor2, product, biggestPalindrom = 1;
		
		
		for (factor1 = 999; factor1 > 900; factor1--) {
			for (factor2 = 999; factor2 > 900; factor2--) {
				product = factor1 * factor2;
				if (product==reverseNumber(product)) {
					biggestPalindrom = (product > biggestPalindrom) ? product : biggestPalindrom;
				}
			}
		}
		System.out.println("Das größte Palindrom ist " + biggestPalindrom + ". Der Algorithmus brauchte " + stopwatch.getDuration() + "mikrosek.");
		return null;
	}

	private int reverseNumber(int product) {
		int intermediate=0, reversed = 0;
		while (product >0) {
			reversed = reversed * 10 + intermediate;
			intermediate = product%10;
			product = product/10;
		}
		reversed = reversed * 10 + intermediate;
		return reversed;
	}

}
