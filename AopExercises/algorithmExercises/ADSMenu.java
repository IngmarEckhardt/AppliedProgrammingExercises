package de.aop.htwk.algorithmExercises;

import java.util.ArrayList;
import java.util.List;

import de.aop.htwk.Menu;
import de.aop.htwk.service.UserInput;

public class ADSMenu implements Menu {
	private boolean exit;
	private List<ADSExercises> exercises;
	
	public ADSMenu() {
		this.exit = false;
	}

	@Override
	public void startMenu() {
		
		do {
			printMenu();
			initializeExercises();
			chooseMenuEntry(UserInput.getInt("Bitte waehlen Sie den Menuepunkt"));
		} while (!exit);
	}
	
	private void initializeExercises() {
		exercises = new ArrayList<ADSExercises>();
		exercises.add(new Laufzeiten());
		
	}

	private void printMenu() {
		System.out.println("\t\t\t\tAlgorithmen und Datenstrukturen-Menu\n" + 
						"\tADS_Uebung_1 \t(1)\n" + 
						"\tADS_Uebung_2 \t(2)\n" + 
						"\tHauptmenue \t(0)");
	}
	
	private Object chooseMenuEntry(Integer menuChoice) {
		if (menuChoice == null) {
			return menuChoice;
		}
		else if (menuChoice == 0) {
			exit = true;
			return menuChoice;	 
		} else {
			(exercises.get(menuChoice-1)).getResult();
			return exercises.get(menuChoice-1);
		}
	}
}
