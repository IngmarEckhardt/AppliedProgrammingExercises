package de.htwk.aopproject.service;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeFactoryImpl implements PrimeFactory {
	private List<Integer> primes;
	
	public PrimeFactoryImpl () {
		primes = new ArrayList<Integer>();	
	}
	
	@Override
	public Integer getPrime(Integer numberOfPrime) {
		if (primes.isEmpty()) {primes = yieldPrimes(Integer.MAX_VALUE);}
		if (numberOfPrime < 1 || numberOfPrime > primes.size()) {
			System.err.println("numberOfPrime out of primeArrayIndex, lastIndex is " + (primes.size()-1) + " and numberOfPrime was " + numberOfPrime);
			return null;
			}
		return primes.get(numberOfPrime-1);
	}
	
	@Override
	public List<Integer> yieldPrimesUpTo10Mio(){
		return this.primes = yieldPrimes(10000000);
	}
	
	@Override
	public List<Integer> yieldPrimesUpTo(Integer value){
		return this.primes = yieldPrimes(value);
	}

	
	@Override
	public IntStream yieldPrimeStream(int maxValue) {
		BitSet primes = new BitSet(maxValue);
		primes.flip(2,primes.size()-1);
		
		int rangeOne = ((int) Math.sqrt(maxValue)) + 1;
		
		for (int i = 2; i < rangeOne; i = primes.nextSetBit(i+1)) {
			
			int rangeTwo = ((maxValue-1)/i)+1;
			for (int j  = 2; j < rangeTwo; j++) {
				primes.set(i*j,false);
			}
		}
		return primes.stream();
	}
	private List<Integer> yieldPrimes(int maxValue) {
		return yieldPrimeStream(maxValue).boxed().collect(Collectors.toList());
	}

}
