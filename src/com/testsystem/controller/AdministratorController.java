package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.Table;
import com.testsystem.models.Administrator;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

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

	public AdministratorController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets new Administrator.
	 */
	public static Administrator getNewAdministrator(String lastName, String firstName, ServerController server,
			String username, String password) {
		return new Administrator(lastName, firstName, server, username, password);
	}

	/**
	 * Gets all users.
	 * 
	 * @param userBase the database of users
	 * @return List<UserModel> the list users
	 */
	public List<User> getAllUsers() {
		return ServiceLocator.getUserController().getAllUsers();
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser the type of user
	 * @return List<User> the list of students
	 */
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		// List<User> listUser =
		@SuppressWarnings("unchecked")
		Table<User> t = (Table<User>) ServiceLocator.getDaoProvider().getTable(User.nameModel);
		List<User> listUser = t.getListRecord();
		for (int i = 0; i < listUser.size(); i++) {
			String className = listUser.get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(listUser.get(i));
			}
		}
		return masUserResult;
	}
}
