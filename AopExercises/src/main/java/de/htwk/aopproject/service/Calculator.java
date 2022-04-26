package de.htwk.aopproject.service;

import java.util.Arrays;

public class Calculator {
	private UserInput userInput;
	
	public Calculator (UserInput userInput) {
		this.userInput = userInput;
	}
	
	public double calcAverage(double[] values) {
		double sum = 0;
		for (double element : values) {
			sum += element;
		}
		return sum/values.length;
	}
	
	public Double calcMedian(double[] values) {
		if (values == null || values.length == 0) return null;
		Arrays.parallelSort(values);
		
		if ((values.length & 1) == 0 ) {
			return (values[(values.length/2)-1] + values[(values.length/2)])/2;
		} else {
			return values[(values.length/2)-1];
		}
	}
	
	public Double calcDeviation(double[] values, Double average) {
		double result = -1.0, intermediateSum = 0.0;
		
		if (values == null) return null;
		if (average == null) calcAverage(values);
		
		for (double element : values) {
			intermediateSum += ((element-average)*(element-average));
		}
		result= Math.sqrt(intermediateSum/(values.length-1));
		
		return result;
	}
}
