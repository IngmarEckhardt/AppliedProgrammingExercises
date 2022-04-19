package de.htwk.aopproject.service;

import java.util.List;
import java.util.stream.IntStream;

public interface PrimeFactory {

	Integer getPrime(Integer numberOfPrime);

	List<Integer> yieldPrimesUpTo10Mio();

	List<Integer> yieldPrimesUpTo(Integer value);

	IntStream yieldPrimeStream(int maxValue);

}