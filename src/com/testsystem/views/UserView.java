package com.testsystem.views;

import com.testsystem.models.User;

/**
 * Represents a user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserView {
	
	private User user;

	/**
	 * Method for open menu.
	 */
	public abstract void openMenu();

	/**
	 * Creates a UserView.
	 */
	public UserView() {
	}

	/**
	 * Creates a UserView.
	 */
	public UserView(User userModel) {
		setUserModel(userModel);
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
