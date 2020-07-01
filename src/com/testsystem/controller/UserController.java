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

	User userModel;
	
	/**
	 * Creates an UserController.
	 */
	public UserController(User userModel) {
		this.userModel=userModel;
	}
	
	/**
	 * @return the userModel
	 */
	public User getUserModel() {
		return userModel;
	}
	
	/**
	 * @param userModel the userModel to set
	 */
	public void setUserModel(User userModel) {
		this.userModel = userModel;
	}
	
}
