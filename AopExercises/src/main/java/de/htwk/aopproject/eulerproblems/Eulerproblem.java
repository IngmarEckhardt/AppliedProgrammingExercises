package de.htwk.aopproject.eulerproblems;

import de.htwk.aopproject.Exercises;

abstract class Eulerproblem extends Exercises {
	
	public Eulerproblem(Integer id, String description) {
		super(id, description);
	}
	
	public Object getResult() {
		return getResultImpl();
	};

	abstract Object getResultImpl();
}
