package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;
import com.testsystem.models.User;
import com.testsystem.models.UserBase;

/**
 * Represents a controller to the database containing user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
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
	 * 
	 * @param userBase the database containing user.
	 */
	public UserBaseController(UserBase userBase) {
		setUserBaseModel(userBase);
	}

	/**
	 * Gets user by login and password.
	 * 
	 * @param username The name of user.
	 * @param password The password of user.
	 * @return UserModel The user.
	 */
	public User getUser(String username, String password) {
		List<User> users = userBase.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * Gets all users
	 * 
	 * @return List<UserModel> the list of users.
	 */
	public List<User> getAllUsers() {
		return userBase.getUsers();
	}

	/**
	 * Adds user.
	 * 
	 * @param user The user.
	 */
	public void addUser(User user) {
		userBase.getUsers().add(user);
	}

	/**
	 * Gets result: does the database have a user.
	 * 
	 * @return boolean Returns true if database contains user.
	 */
	public boolean hasUser(User user) {
		List<User> users = userBase.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets database of user.
	 * 
	 * @return the database of user.
	 */
	public UserBase getUserBaseModel() {
		return userBase;
	}

	/**
	 * Sets database of user
	 * 
	 * @param userBase The database of user.
	 */
	public void setUserBaseModel(UserBase userBase) {
		this.userBase = userBase;
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser The user's type.
	 * @return List<UserModel> The list of students.
	 */
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i < userBase.getUsers().size(); i++) {
			String className = userBase.getUsers().get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(userBase.getUsers().get(i));
			}
		}
		return masUserResult;
	}

}
