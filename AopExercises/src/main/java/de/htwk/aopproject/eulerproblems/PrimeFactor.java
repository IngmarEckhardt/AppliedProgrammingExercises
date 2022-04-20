package de.htwk.aopproject.eulerproblems;


import de.htwk.aopproject.service.PrimeFactory;
import de.htwk.aopproject.service.Stopwatch;

class PrimeFactor extends Eulerproblem {
	private Stopwatch stopwatch;
	private PrimeFactory primeFactory;

	public PrimeFactor(Integer id, Stopwatch stopwatch, PrimeFactory primeFactory) {
		super(id, "Eulerproblem 3, was ist der größte Primfaktor");
		this.stopwatch = stopwatch;
		this.primeFactory = primeFactory;
	}

	@Override
	Object getResultImpl() {
		stopwatch.startClock();
		Long value2 = 600851475143L;
		primeFactory.yieldPrimesUpTo((int) Math.sqrt(value2));
		System.out.println("Eratosthenes brauchte " + stopwatch.getDurationMillis() + "millisekunden.");
		stopwatch.startClock();
		String result = getPrimeFactorization(value2);
		System.out.println(result);
		System.out.println("Der weitere Algorithmus brauchte " + stopwatch.getDurationMillis() + "millisekunden.");
		
		stopwatch.startClock();
		String result2 = getPrimeFactorizationVers2(value2);
		System.out.println(result2+ " Der Algoritmus brauchte " + stopwatch.getDurationMillis() + "millisekunden.");
		
		return result;
	}

	private String getPrimeFactorization(Long product) {
		long factor = 1;
		int primeIndex = 1, exponent = 0;
		String result = "Die Primfaktoren von " + product + " sind: 1";
		
		while (product != 1) {

			exponent = 0;
			factor = primeFactory.getPrime(primeIndex);
			while ( product % factor == 0)
			{
				exponent++;
				product = product/factor;
			}
			
			if (exponent > 0) {
				result = result + " * " + factor + "^" + exponent;
			}
			primeIndex++;
		}
		result = result + ". Der größte Primfaktor ist " + factor;
		
		return result;
	}
	private String getPrimeFactorizationVers2(Long product) {
		int exponent = 0;
		long factor = 1;
		String result  = "Die Primfaktoren von " + product + " sind: 1";
		
		while (product != 1) {
			exponent = 0;
			factor++;
			while (product % factor == 0) {
				exponent++;
				product = product/factor;
			}
			if (exponent > 0) {
				result = result + " * " + factor + "^" + exponent;
			}
		}
		result = result + ". Der größte Primfaktor ist " + factor;
	 return result;
	}

}
