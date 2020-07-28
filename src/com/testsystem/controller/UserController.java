package com.testsystem.controller;

import java.util.List;

import com.testsystem.models.Model;
import com.testsystem.models.User;
import com.testsystem.util.ServiceLocator;

/**
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserController {

	private User user;
	
	/**
	 * Creates an UserController.
	 */
	public UserController() {}
	
	/**
	 * Creates an UserController.
	 */
	public UserController(User user) {
		setUser(user);
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
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Gets user by login and password.
	 * 
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return UserModel 	the user
	 */
	public User getUser(String username, String password) {
		List<Model> users = ServiceLocator.getDaoProvider()
				.getRecordsTable(User.nameModel);
		for (int i = 0; i < users.size(); i++) {
			User u = (User)users.get(i);
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Gets all users.
	 * 
	 * @return List<UserModel> the list of users
	 */
	public List<Model> getAllUsers() {
		List<Model> users = ServiceLocator.getDaoProvider()
				.getRecordsTable(User.nameModel);
		return users;
	}

	/**
	 * Adds user.
	 * 
	 * @param user the user.
	 */
	public void addUser(User user) {
		ServiceLocator.getDaoProvider().addRecord(user);
	}

	/**
	 * Gets result: does the database have a user.
	 * 
	 * @return boolean Returns true if database contains user
	 */
	public boolean hasUser(User user) {
		List<Model> users = ServiceLocator.getDaoProvider()
				.getRecordsTable(User.nameModel);
		for (int i = 0; i < users.size(); i++) {
			User u = (User)users.get(i);
			if (u.getId() == user.getId()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets users by type.
	 * 
	 * @param typeUser 			the type of user
	 * @return List<UserModel> 	the list of students
	 */
	public List<Model> getUsersByType(String typeUser) {
		List<Model> listUserResult = ServiceLocator.getDaoProvider()
				.getRecordsTable(User.nameModel);
		for (int i = 0; i < listUserResult.size(); i++) {
			String className = listUserResult.get(i).getNameModel();
			if (className.equals(typeUser)) {
				listUserResult.add(listUserResult.get(i));
			}
		}
		return listUserResult;
	}
}
