package de.htwk.aopproject.aopexercises;

import de.htwk.aopproject.Exercises;

abstract class AOPExercises extends Exercises {

	public AOPExercises(Integer id, String description) {
		super(id, description);
	}

	public Object getResult() {
		return getResultImpl();
	};

	abstract Object getResultImpl();
}
