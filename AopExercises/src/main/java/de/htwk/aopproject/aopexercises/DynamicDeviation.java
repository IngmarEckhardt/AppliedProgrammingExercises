package de.htwk.aopproject.aopexercises;

import java.util.ArrayList;
import java.util.Random;

import de.htwk.aopproject.service.Calculator;

class DynamicDeviation extends AOPExercises {
	private Random random;
	private Calculator calculator;
	private double[] values;
	private ArrayList<Double> dynamicValues;
	private int counter;
	private Double average, median, sigma, dynamicAverage, dynamicSigma;
	private double lastDynamicAverage;

	public DynamicDeviation(Integer id, Calculator calculator) {
		super(id, "Rechner für statistische Werte");
		this.random = new Random(System.nanoTime());
		this.calculator = calculator;
		dynamicValues = new ArrayList<Double>();
	}

	@Override
	Object getResultImpl() {
		values = getRandomField();
		
		for (int i = 0; i < 40 && i < values.length; i++) {
			dynamicSigma = calcDynamicDeviation(values[i]);
			
		 System.out.printf("Die dynamisch berechnete Standardabweichung beträgt %1$.3f. Der Mittelwert beträgt %2$.3f. Bei einem n = %3$d \n", dynamicSigma, dynamicAverage, counter);
		 
		}
		
		average = calculator.calcAverage(values);
		median = calculator.calcMedian(values);
		sigma = calculator.calcDeviation(values, average);
		
		System.out.println("Der Durchschnittswert ist " + average + ". Der Median liegt bei " + median + ". und die Standardabweichung bei sigma = " + sigma +".");
		return null;
	}
	

	public Double calcDynamicDeviation (Double valueToAdd) {
		Double result = -1.0, dynamicS = null;
		if (valueToAdd == null) return null;

		dynamicValues.add(valueToAdd);
		
		if (dynamicAverage == null) {
			dynamicAverage = valueToAdd;
			dynamicS = 0d;
			lastDynamicAverage = valueToAdd;
			counter = 1;
		} else {
			counter++;
			lastDynamicAverage = dynamicAverage;
			dynamicAverage = dynamicAverage + ((valueToAdd  - dynamicAverage)/ counter);
			dynamicS = dynamicS + ((valueToAdd-lastDynamicAverage) * (valueToAdd-dynamicAverage));
		}
		
		if (counter > 1) {
			result = Math.sqrt(dynamicS/(counter-1));
		}
		
		return result;
	}
	
	public Boolean resetDynamicArray () {
		if (dynamicValues == null) return null;
		dynamicValues.clear();
		dynamicAverage = 0d;
		lastDynamicAverage = 0d;
		
		return true;
	}

	private double[] getRandomField() {
		int randomInt = Math.abs(random.nextInt(10000000));
		double[] randomfield = new double[randomInt];
		
		for (int i = 0; i < randomfield.length; i++) {
			randomfield[i]= random.nextDouble() * 1000;
		}
		return randomfield;
	}

}
