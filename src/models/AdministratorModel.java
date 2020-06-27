package models;

import controllers.ServerController;

/**
 * Represents an administrator.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdministratorModel extends UserModel {
	
	private static final String nameModel = "AdministratorModel"; 
	
	public static String getNameModel() {
		return nameModel;
	}

	public AdministratorModel(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

}
