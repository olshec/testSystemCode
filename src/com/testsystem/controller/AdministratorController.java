package com.testsystem.controller;

import java.util.List;

import com.testsystem.DAO.Providers.UserTableProvider;
import com.testsystem.DAO.Tables.UserTable;
import com.testsystem.models.Administrator;
import com.testsystem.models.User;

/**
 * Represents an AdministratorController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdministratorController extends UserController {

	/**
	 * Creates an AdministratorController.
	 * 
	 * @param user
	 */
	public AdministratorController(User user) {
		super(user);
	}
	
	/**
	 * Gets new Administrator.
	 */
	public static Administrator getNewAdministrator(String lastName, String firstName, 
			ServerController server, String username, String password) {
		return new Administrator(lastName, firstName, server, username, password);
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser 			the user's type
	 * @param userBase 			the database of users
	 * @return List<UserModel> 	the list students
	 */
	public List<User> getUsersByType(String typeUser, UserTable userBase) {
		return new UserTableProvider(userBase).getUsersByType(typeUser);
	}

	/**
	 * Gets all users.
	 * 
	 * @param userBase the database of users
	 * @return List<UserModel> the list users
	 */
	public List<User> getAllUsers(UserTable userBase) {
		return new UserTableProvider(userBase).getAllUsers();
	}
}
