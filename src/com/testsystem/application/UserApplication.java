package com.testsystem.application;

import com.testsystem.controller.FrontController;
import com.testsystem.model.User;

/**
 * Abstract class application for user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserApplication {
	
	private User user;
	private FrontController frontController;

	/**
	 * Method for open menu.
	 */
	public abstract void openMenu();

	/**
	 * Creates a UserView.
	 */
	public UserApplication() {
	}

	/**
	 * Creates a UserView.
	 */
	public UserApplication(User userModel, FrontController frontController) {
		setUserModel(userModel);
		setFrontController(frontController);
	}

	/**
	 * Gets user.
	 * 
	 * @return the user
	 */
	public User getUser() {
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
	
	public void setFrontController(FrontController frontController) {
		this.frontController = frontController;
	}
	
	public FrontController getFrontController() {
		return frontController;
	}
}
