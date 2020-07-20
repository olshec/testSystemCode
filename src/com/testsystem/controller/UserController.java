package com.testsystem.controller;

import com.testsystem.models.User;

/**
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserController {

	User user;

	/**
	 * Creates an UserController.
	 */
	public UserController(User user) {
		this.user = user;
	}

	/**
	 * Gets user.
	 * 
	 * @return the user
	 */
	public User getUserModel() {
		return user;
	}

	/**
	 * Sets user.
	 * 
	 * @param user the user
	 */
	public void setUserModel(User user) {
		this.user = user;
	}
}
