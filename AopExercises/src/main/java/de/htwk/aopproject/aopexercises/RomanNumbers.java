package de.htwk.aopproject.aopexercises;

import de.htwk.aopproject.service.UserInput;

class RomanNumbers extends AOPExercises {
	private String result;
	private int decimalNumber;
	private UserInput userInput;
	
	RomanNumbers(int id, UserInput userInput) {
		super(id, "Dezimalzahlen in römische Zahlen umrechen");
		this.userInput = userInput;
	}

	Object getResultImpl() {
		do {
			do {
				decimalNumber = userInput
						.getInt("Gib die Zahl bis 4000 an, welche in Römische Ziffern umgerechnet wird: \n");
			} while (!correctNumber());
			calculateNumber();
		} while (userInput.jaNeinQuestion("Möchten Sie erneut eine Nummer umwandeln? (J/N)"));

		return null;
	}

	private void calculateNumber() {
		result = "";
		int[] divisors = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanChar = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int intermediate;

		do {
			for (int i = 0; i < divisors.length; i++) {
				intermediate = decimalNumber / divisors[i];
				for (; intermediate > 0; intermediate--) {
					result = result + romanChar[i];
				}
				decimalNumber %= divisors[i];
			}

		} while (decimalNumber >= 1);

		System.out.println("Die römische Zahl ist: " + result);
	}

	private boolean correctNumber() {
		if (decimalNumber > 0 & decimalNumber < 4001) {
			return true;
		}
		System.out.println("Bitte geben Sie nur positive Nummern zwischen 0 und 4000 ein");
		return false;
	}
}