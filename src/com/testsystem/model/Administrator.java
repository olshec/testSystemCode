package com.testsystem.model;

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
	 * Creates an AdministratorModel.
	 */
	public Administrator() {	}
	
	/**
	 * Creates an AdministratorModel.
	 * 
	 * @param lastName  the user’s last name
	 * @param firstName the user’s first name
	 * @param server    the user’s server
	 * @param username  the user’s username
	 * @param password  the user’s password
	 */
	public Administrator(String lastName, String firstName, String username, String password) {
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
