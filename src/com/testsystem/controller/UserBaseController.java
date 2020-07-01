package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * Represents a controller to the database containing user.
 * 
 * @author Oleg Shestakov
 * 
 * @author olshec@gmail.com
 * 
 * @version 1.0
 */

public class UserBaseController {
	private UserBase userBase;

	/** 
	 * Creates a UserBaseController.
	 */
	public UserBaseController() {
		userBase = new UserBase();
	}
	
	/** 
	 * Creates a UserBaseController.
	 * @param userBaseModel the database containing user.
	 */
	public UserBaseController(UserBase userBaseModel) {
		setUserBaseModel(userBaseModel);
	}

	/**
	 * @param username the name of user.
	 * @param password the password of user.
	 * @return UserModel the user.
	 */
	public User getUser(String username, String password) {
		List<User> users=userBase.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * @return List<UserModel> the list users.
	 */
	public List<User> getUsers() {
		return userBase.getUsers();
	}

	/**
	 * @param user the user's model.
	 */
	public void addUser(User user) {
		userBase.getUsers().add(user);
	}

	/**
	 * @return boolean return true if database contains user.
	 */
	public boolean hasUser(User user) {
		List<User> users=userBase.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the userBaseModel.
	 */
	public UserBase getUserBaseModel() {
		return userBase;
	}

	/**
	 * @param userBaseModel the userBaseModel to set.
	 */
	public void setUserBaseModel(UserBase userBaseModel) {
		this.userBase = userBaseModel;
	}

	/** 
	 * Gets users by type.
	 * @param typeUser the user's type.
	 * @return List<UserModel> The list students.
	 */
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i <userBase.getUsers().size(); i++) {
			String className = userBase.getUsers().get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(userBase.getUsers().get(i));
			}
		}
		return masUserResult;
	}
	
}
