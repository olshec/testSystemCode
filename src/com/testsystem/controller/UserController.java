package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.DAOProvider;
import com.testsystem.models.User;

/**
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserController {

	private User user;
	private DAOProvider daoProvider;
	
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
	 * Creates an UserController.
	 */
	public UserController(DAOProvider daoProvider) {
		setDaoProvider(daoProvider);
	}
	
	/**
	 * Creates an UserController.
	 */
	public UserController(User user, DAOProvider daoProvider) {
		setUser(user);
		setDaoProvider(daoProvider);
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
	 * Gets DAOProvider.
	 * 
	 * @return the DAOProvider
	 */
	public DAOProvider getDaoProvider() {
		return daoProvider;
	}
	
	/**
	 * Sets DAOProvider.
	 * 
	 * @param daoProvider the DAOProvider to set
	 */
	public void setDaoProvider(DAOProvider daoProvider) {
		this.daoProvider = daoProvider;
	}
	
	/**
	 * Gets user by login and password.
	 * 
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return UserModel 	the user
	 */
	public User getUser(String username, String password) {
		List<User> users = daoProvider.getUserTable().getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(username) && users.get(i)
					.getPassword().equals(password)) {
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
		return this.daoProvider.getUserTable().getUsers();
	}

	/**
	 * Adds user.
	 * 
	 * @param user the user.
	 */
	public void addUser(User user) {
		daoProvider.getUserTable().getUsers().add(user);
	}

	/**
	 * Gets result: does the database have a user.
	 * 
	 * @return boolean Returns true if database contains user
	 */
	public boolean hasUser(User user) {
		List<User> users = daoProvider.getUserTable().getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId()) {
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
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i < daoProvider.getUserTable().getUsers().size(); i++) {
			String className = daoProvider.getUserTable().getUsers().get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(daoProvider.getUserTable().getUsers().get(i));
			}
		}
		return masUserResult;
	}
}
