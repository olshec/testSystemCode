/**
 * 
 */
package com.testsystem.controller;

import java.util.List;

import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * AdministratorController
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public class AdministratorController extends UserController {

	/**
	 * Creates an AdministratorController.
	 * @param userModel
	 */
	public AdministratorController(User userModel) {
		super(userModel);
	}

	/**
	 * Gets users by type.
	 * @param typeUser the user's type.
	 * @param userBase the userBase.
	 * @return List<UserModel> The list students.
	 */
	public List<User> getUsersByType(String typeUser, UserBase userBase) {
		return new UserBaseController(userBase).getUsersByType(typeUser);
	}

	/**
	 * @return List<UserModel> the list users.
	 */
	public List<User> getUsers(UserBase userBasemodel) {
		return new UserBaseController(userBasemodel).getUsers();
	}

}
