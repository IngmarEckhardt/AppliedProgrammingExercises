package de.aop.htwk.algorithmExercises;

abstract class ADSExercises {
	private Integer id;
	private String description;
	
	void setId(Integer id) {
		this.id = id;
	}

	void setDescription(String description) {
		this.description = description;
	}
	
	abstract Object getResult();
}
