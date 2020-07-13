package com.testsystem.controller;

import java.util.List;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * AdministratorController
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
	 * Gets users by type.
	 * 
	 * @param typeUser The user's type.
	 * @param userBase The database of users.
	 * @return List<UserModel> The list students.
	 */
	public List<User> getUsersByType(String typeUser, UserBase userBase) {
		return new UserBaseController(userBase).getUsersByType(typeUser);
	}

	/**
	 * Gets all users.
	 * 
	 * @param userBase The database of users.
	 * @return List<UserModel> The list users.
	 */
	public List<User> getAllUsers(UserBase userBase) {
		return new UserBaseController(userBase).getAllUsers();
	}

}
