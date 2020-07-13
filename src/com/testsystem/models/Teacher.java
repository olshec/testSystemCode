package com.testsystem.models;

import com.testsystem.controller.ServerController;

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
	 * 
	 * @param lastName The user’s last name.
	 * @param firstName The user’s first name.
	 * @param server The user’s server.
	 * @param username The user’s username.
	 * @param password The user’s password.
	 */
	public Teacher(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

}
