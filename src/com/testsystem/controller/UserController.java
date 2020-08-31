package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Administrator;
import com.testsystem.model.Model;
import com.testsystem.model.Student;
import com.testsystem.model.Teacher;
import com.testsystem.model.User;
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
	 * @return User 		the user
	 */
	public User getUser(String username, String password) {
		User u = getListUserByType(Administrator.nameModel, username, password);
		if(u != null) {
			return u;
		} 
		u = getListUserByType(Teacher.nameModel, username, password);
		if(u != null) {
			return u;
		} 	
		u = getListUserByType(Student.nameModel, username, password);
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
	 * Gets all users.
	 * 
	 * @return List<UserModel> the list of users
	 */
	public List<Model> getAllUsers() {
		List<Model> administrators = ServiceLocator.getDaoProvider()
				.getRecords(Administrator.nameModel);
		List<Model> teachers = ServiceLocator.getDaoProvider()
				.getRecords(Teacher.nameModel);
		List<Model> students = ServiceLocator.getDaoProvider()
				.getRecords(Student.nameModel);
		List<Model> usersList = new ArrayList<Model>();
		usersList.addAll(administrators);
		usersList.addAll(teachers);
		usersList.addAll(students);
		return usersList;
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
		List<User> users = ServiceLocator.getDaoProvider()
				.getUsersRecords(User.nameModel);
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
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
				.getRecords(typeUser);
		return listUserResult;
	}
}
