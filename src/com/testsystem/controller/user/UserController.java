package com.testsystem.controller.user;

import java.util.List;

import com.testsystem.model.user.Administrator;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
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
	 * Returns user by login and password.
	 * 
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return User 		the user
	 */
	public User getUser(String username, String password) {
		User u = getListUserByType(new Administrator().getNameModel(), username, password);
		if(u != null) {
			return u;
		} 
		u = getListUserByType(new Teacher().getNameModel(), username, password);
		if(u != null) {
			return u;
		} 	
		u = getListUserByType(new Student().getNameModel(), username, password);
		if(u != null) {
			return u;
		} 
		return null;
	}
	
	/*
	 * Gets user by type.
	 * 
	 * @param nameModel		the name of model user
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return User 		the user
	 */
	private User getListUserByType(String nameModel, String username, String password) {
		List<User> users = ServiceLocator.getDaoProvider()
				.getUsersRecords(nameModel);
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;

	}

	/**
	 * Saves user in database.
	 * 
	 * @param User the user.
	 */
	public void saveUserInDatabase(User user) {
		ServiceLocator.getDaoProvider().addRecord(user);
	}

}
