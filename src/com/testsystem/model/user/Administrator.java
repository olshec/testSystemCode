package com.testsystem.model.user;

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
	 * Creates an Administrator.
	 * 
	 * @param String  the user’s last name
	 * @param String  the user’s first name
	 * @param String  the user’s username
	 * @param String  the user’s password
	 */
	public Administrator(String lastName, String firstName, String username, String password) {
		super(lastName, firstName, username, password);
	}
	
	/**
	 * Returns the name of model administrator.
	 * 
	 * @return String the name of model
	 */
	public String getNameModel() {
		return nameModel;
	}
}
