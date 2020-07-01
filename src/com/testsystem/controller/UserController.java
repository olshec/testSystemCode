package com.testsystem.controller;
import com.testsystem.models.User;

/**
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public abstract class UserController {

	User user;
	
	/**
	 * Creates an UserController.
	 */
	public UserController(User userModel) {
		this.user=userModel;
	}
	
	/**
	 * @return the userModel
	 */
	public User getUserModel() {
		return user;
	}
	
	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(User userModel) {
		this.user = userModel;
	}
	
}
