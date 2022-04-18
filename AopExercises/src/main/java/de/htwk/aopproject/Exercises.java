package de.htwk.aopproject;

public abstract class Exercises {
	private Integer id;
	private String description;
	
	public Exercises(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Integer getID () {
		return id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract Object getResult();
	
	
	// For purpose of Unit-Tests	
	void setId(Integer id) {
		this.id = id;
	}
	
	void setDescription(String description) {
		this.description = description;
	}
}
