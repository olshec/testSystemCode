package com.testsystem.view;

import com.testsystem.controller.FrontController;
import com.testsystem.model.user.User;

/**
 * Represents an abstract class view for users.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserView {
	
	private User user;
	private FrontController frontController;

	/**
	 * Method for open menu.
	 */
	public abstract void openMenu();

	/**
	 * Creates a UserView.
	 */
	public UserView() {}

	/**
	 * Creates a UserView.
	 */
	public UserView(User userModel, FrontController frontController) {
		setUser(userModel);
		setFrontController(frontController);
	}

	/**
	 * Returns user.
	 * 
	 * @return User the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets user.
	 * 
	 * @param User the user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Sets frontController.
	 * 
	 * @param FrontController the FrontController
	 */
	public void setFrontController(FrontController frontController) {
		this.frontController = frontController;
	}
	
	/**
	 * Returns FrontController.
	 * 
	 * @return FrontController the FrontController
	 */
	public FrontController getFrontController() {
		return frontController;
	}
}
