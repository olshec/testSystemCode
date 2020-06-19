package models;

import controllers.ServerController;

public class AdminModel extends UserModel {

	public AdminModel(String lastName, String firstName, ServerController server, String username, String password) {
		super(lastName, firstName, server, username, password);
	}

}
