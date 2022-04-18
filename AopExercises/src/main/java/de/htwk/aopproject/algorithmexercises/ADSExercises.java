package de.htwk.aopproject.algorithmexercises;

import de.htwk.aopproject.Exercises;

abstract class ADSExercises extends Exercises {
	
	public ADSExercises(Integer id, String description) {
		super(id, description);
	}
	public Object getResult() {
			return getResultImpl();
	};

	abstract Object getResultImpl();
}
