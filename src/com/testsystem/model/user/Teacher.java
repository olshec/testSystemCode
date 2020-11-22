package com.testsystem.model.user;

/**
 * Represents a teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Teacher extends User {

	public static final String nameModel = "Teacher";
	
	/** 
	 * Creates a TeacherModel.
	 */
	public Teacher() {}
	
	/**
	 * Creates an TeacherModel.
	 * 
	 * @param String  the user’s last name
	 * @param String  the user’s first name
	 * @param String  the user’s username
	 * @param String  the user’s password
	 */
	public Teacher(String lastName, String firstName, String username, String password) {
		super(lastName, firstName, username, password);
	}
	
	/**
	 * Returns the name of model teacher.
	 * 
	 * @return String the name of model
	 */
	public String getNameModel() {
		return nameModel;
	}
}
