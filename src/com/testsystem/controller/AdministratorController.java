package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.DAOProvider;
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

	private DAOProvider daoProvider;
	
	/**
	 * Creates an AdministratorController.
	 * 
	 * @param user
	 */
	public AdministratorController(User user) {
		super(user);
	}
	
	/**
	 * Creates an AdministratorController.
	 * 
	 * @param daoProvider
	 */
	public AdministratorController(DAOProvider daoProvider) {
		super();
		setDaoProvider(daoProvider);
	}
	
	/**
	 * Creates an AdministratorController.
	 * 
	 * @param user
	 * @param daoProvider
	 */
	public AdministratorController(User user, DAOProvider daoProvider) {
		super(user);
		setDaoProvider(daoProvider);
	}
	
	/**
	 * Gets DAOProvider.
	 * 
	 * @return the DAOProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}
	
	/**
	 * Sets DAOProvider.
	 * 
	 * @param daoProvider the DAOProvider to set
	 */
	public void setDaoProvider(DAOProvider daoProvider) {
		this.daoProvider = daoProvider;
	}
	
	/**
	 * Gets new Administrator.
	 */
	public static Administrator getNewAdministrator(String lastName, String firstName, 
			ServerController server, String username, String password) {
		return new Administrator(lastName, firstName, server, username, password);
	}

	/**
	 * Gets all users.
	 * 
	 * @param userBase the database of users
	 * @return List<UserModel> the list users
	 */
	public List<User> getAllUsers() {
		return new UserController(daoProvider).getAllUsers();
	}
	
	/**
	 * Gets users by type.
	 * 
	 * @param typeUser 			the type of user
	 * @return List<User> 		the list of students
	 */
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i < daoProvider.getUserTable().getUsers().size(); i++) {
			String className = daoProvider.getUserTable().getUsers().get(i)
					.getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(daoProvider.getUserTable().getUsers().get(i));
			}
		}
		return masUserResult;
	}
}
