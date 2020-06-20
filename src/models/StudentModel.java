package models;

import controllers.ServerController;

/**
 * Represents a student.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class StudentModel extends UserModel {

	public StudentModel(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
		// TODO Auto-generated constructor stub
	}

}
