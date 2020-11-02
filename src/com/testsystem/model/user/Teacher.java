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
	 * Creates a TeacherModel.
	 * 
	 * @param lastName  the user’s last name
	 * @param firstName the user’s first name
	 * @param server    the user’s server
	 * @param username  the user’s username
	 * @param password  the user’s password
	 */
	public Teacher(String lastName, String firstName, String username, String password) {
		super(lastName, firstName, username, password);
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	public String getNameModel() {
		return nameModel;
	}
}
