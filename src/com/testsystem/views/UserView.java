package com.testsystem.views;

import com.testsystem.models.User;

/**
 * Represents a user.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public abstract class UserView {
	private User user;
	
	/** 
	 * Menu.
	*/
	public abstract void openMenu();
	
	/** 
	 * Creates a UserView.
	 */
	public UserView() {}
	
	/** 
	 * Creates a UserView.
	 */
	public UserView(User userModel) {
		setUserModel(userModel);
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
