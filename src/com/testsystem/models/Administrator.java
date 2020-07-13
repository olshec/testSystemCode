package com.testsystem.models;

import com.testsystem.controller.ServerController;

/**
 * Represents an administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Administrator extends User {
	
	public static final String nameModel = "Administrator";

	/** 
	 * Creates a AdministratorModel.
	 * 
	 * @param lastName The user’s last name.
	 * @param firstName The user’s first name.
	 * @param server The user’s server.
	 * @param username The user’s username.
	 * @param password The user’s password.
	 */
	public Administrator(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

}
