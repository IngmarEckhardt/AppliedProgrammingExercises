package de.htwk.aopproject.service;

public interface UserInput {

	String getString(String message);

	Integer getInt(String message);

	boolean jaNeinQuestion(String message);

}