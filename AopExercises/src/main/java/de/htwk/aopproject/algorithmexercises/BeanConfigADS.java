package de.htwk.aopproject.algorithmexercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import de.htwk.aopproject.Factory;
import de.htwk.aopproject.service.Stopwatch;
import de.htwk.aopproject.service.UserInput;

@Configuration
public class BeanConfigADS {
	
	@Autowired
	private UserInput userInput;
	
	@Autowired
	private Stopwatch stopwatch;

	@Bean
	public Factory adsFactory () {
		return new ADSFactory(userInput, stopwatch);
	}
}
