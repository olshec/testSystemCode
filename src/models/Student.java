package models;

import controllers.ServerController;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class Student extends User {
	
	public static final String nameModel = "StudentModel";

	/** Creates a StudentModel
	 *@param lastName The user’s last name.
	 * @param firstName The user’s first name.
	 * @param server The user’s server.
	 * @param username The user’s username.
	 * @param password The user’s password.
	 */
	public Student(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

}
