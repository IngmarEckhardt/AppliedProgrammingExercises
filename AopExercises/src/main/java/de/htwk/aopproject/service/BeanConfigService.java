package de.htwk.aopproject.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigService {
	
	@Bean
	public UserInput userInput () {
		return new UserInputImpl(bufferedReader());
	}
	
	@Bean
	public Stopwatch stopwatch () {
		return new StopwatchImpl();
	}
	
	@Bean
	public PrimeFactory primeFactory () {
		return new PrimeFactoryImpl();
	}
	
	@Bean
	BufferedReader bufferedReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
}
