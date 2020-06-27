package models;

import controllers.ServerController;

/**
 * Represents a teacher.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class TeacherModel extends UserModel {

	public static final String nameModel = "TeacherModel";
	
	public TeacherModel(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
		// TODO Auto-generated constructor stub
	}

}
