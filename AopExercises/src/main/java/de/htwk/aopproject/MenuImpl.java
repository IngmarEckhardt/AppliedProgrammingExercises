package de.htwk.aopproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


import de.htwk.aopproject.algorithmexercises.ADSFactory;
import de.htwk.aopproject.aopexercises.AOPFactory;
import de.htwk.aopproject.eulerproblems.EulerFactory;
import de.htwk.aopproject.service.UserInput;

class MenuImpl implements Menu {
	private boolean exit;

	private UserInput userInput;
	private ADSFactory adsFactory;
	private AOPFactory aopFactory;
	private EulerFactory eulerFactory;
	private List<Exercises> adsExercises, aopExercises, eulerProblems;

	public MenuImpl(UserInput userInput, ADSFactory adsFactory, AOPFactory aopFactory, EulerFactory eulerFactory) {
		this.exit = false;
		this.userInput = userInput;
		this.adsFactory = adsFactory;
		this.aopFactory = aopFactory;
		this.eulerFactory = eulerFactory;
		adsExercises = new ArrayList<Exercises>();
		aopExercises = new ArrayList<Exercises>();
		eulerProblems = new ArrayList<Exercises>();
	}

	public void startMenu() {

		ForkJoinPool parallelThreadPool = new ForkJoinPool(4);
		parallelThreadPool.execute(() -> yieldExercises(adsFactory, adsExercises));
		parallelThreadPool.execute(() -> yieldExercises(aopFactory, aopExercises));
		parallelThreadPool.execute(() -> yieldExercises(eulerFactory, eulerProblems));
		do {
			printMenu();
			chooseMenuEntry(userInput.getInt("Bitte waehlen Sie einen Menuepunkt"));
		} while (!exit);
	}

	private void printMenu() {
		System.out.println("\t\t\t\tMenu\n" + "\tAOP_Menu \t\t(1)\n" + "\tEulerMenu \t\t(2)\n"
				+ "\tAlgorithmenMenu \t(3)\n" + "\tExit \t\t\t(0)");
	}

	private Object chooseMenuEntry(Integer menuChoice) {

		switch (menuChoice) {
		case 0:
			exit = true;
			return menuChoice;
		case 1:
			return subMenu(aopExercises);
		case 2:
			return subMenu(eulerProblems);
		case 3:
			return subMenu(adsExercises);
		default:
			System.out.println("Bitte wählen Sie nur aus den vorgegebenen Menüpunkten");
			return null;
		}
	}

	private Object subMenu(List<Exercises> exercises) {
		int menuChoice = -1;
		Object result = null;

		do {
			for (Exercises exerInstance : exercises) {
				if (exerInstance != null)
					System.out.println(exerInstance.getDescription() + " (" + exerInstance.getID() + ")");
			}
			System.out.println("Hauptmenue (0)");
			
			menuChoice = userInput.getInt("Bitte waehlen Sie einen Menuepunkt");
			if (menuChoice < 0 || menuChoice > (exercises.size())) {
				System.out.println("Wählen Sie nur aus den gegebenen Menüpunkten");
				continue;
			} else if (menuChoice == 0) {
				return null;
			} else {
				result = exercises.get(menuChoice - 1).getResult();
			}

		} while (menuChoice != 0);
		return result;
	}

	private List<Exercises> yieldExercises(Factory factory, List<Exercises> exercises) {
		do {
			exercises.add(factory.getInstance());
		} while (exercises.get((exercises.size() - 1)) != null);
		exercises.remove((exercises.size() - 1));
		return exercises;
	}
}