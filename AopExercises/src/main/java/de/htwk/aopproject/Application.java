package de.htwk.aopproject;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import de.htwk.aopproject.algorithmexercises.ADSFactory;
import de.htwk.aopproject.aopexercises.AOPFactory;
import de.htwk.aopproject.eulerproblems.EulerFactory;
import de.htwk.aopproject.service.BeanConfigService;
import de.htwk.aopproject.service.UserInput;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(MenuImpl.class, BeanConfigService.class, ADSFactory.class, AOPFactory.class, EulerFactory.class);
		applicationContext.refresh();
		Menu menu = applicationContext.getBean(MenuImpl.class);
		menu.startMenu();
		System.out.println("Programm wird beendet");
		applicationContext.close();
	}
}
