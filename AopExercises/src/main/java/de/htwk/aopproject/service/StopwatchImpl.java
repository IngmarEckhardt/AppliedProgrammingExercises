package de.htwk.aopproject.service;

public class StopwatchImpl implements Stopwatch {
	private long start, end; 
	
	@Override
	public void startClock() {
		start = System.nanoTime();		
	}
	@Override
	public double getDuration() {
		end = System.nanoTime();
		return (end-start)/1000.0;
	}
	
	@Override
	public double getDurationMillis() {
		end = System.nanoTime();
		return (end-start)/1000000.0;
	}
}
