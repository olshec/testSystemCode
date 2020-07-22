package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.Test;
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
//	public UserBaseController() {
//		userBase = new UserBase();
//	}

	/**
	 * Creates a UserBaseController.
	 * 
	 * @param userBase the database containing user.
	 */
	public UserBaseController(UserBase userBase) {
		setUserBase(userBase);
	}

	/**
	 * Gets new UserBase.
	 */
	public static UserBase getNewUserBase() {
		return new UserBase();
	}
	
	/**
	 * Gets user by login and password.
	 * 
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return UserModel 	the user
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
	 * Gets all users.
	 * 
	 * @return List<UserModel> the list of users
	 */
	public List<User> getAllUsers() {
		return userBase.getUsers();
	}

	/**
	 * Adds user.
	 * 
	 * @param user the user.
	 */
	public void addUser(User user) {
		userBase.getUsers().add(user);
	}

	/**
	 * Gets result: does the database have a user.
	 * 
	 * @return boolean Returns true if database contains user
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
	 * @return the database of user
	 */
	public UserBase getUserBase() {
		return userBase;
	}

	/**
	 * Sets database of user.
	 * 
	 * @param userBase the database of user
	 */
	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser 			the type of user
	 * @return List<UserModel> 	the list of students
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
