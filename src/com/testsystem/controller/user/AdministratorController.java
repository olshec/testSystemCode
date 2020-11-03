package com.testsystem.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.user.Administrator;
import com.testsystem.model.user.Student;
import com.testsystem.model.user.Teacher;
import com.testsystem.model.user.User;
import com.testsystem.util.ServiceLocator;

/**
 * Represents an AdministratorController.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class AdministratorController extends UserController {

	/**
	 * Creates an AdministratorController.
	 * 
	 * @param user
	 */
	public AdministratorController(User user) {
		super(user);
	}

	/**
	 * Creates an AdministratorController.
	 */
	public AdministratorController() {}

	/**
	 * Gets new Administrator.
	 */
	public Administrator getNewAdministrator(String lastName, 
			String firstName, String username, String password) {
		return new Administrator(lastName, firstName, username, password);
	}

	/**
	 * Gets all users.
	 * 
	 * @param userBase the database of users
	 * @return List<UserModel> the list users
	 */
	public List<User> getAllUsers() {
		//return new UserController().getAllUsers();
		List<User> administrators = ServiceLocator.getDaoProvider()
				.getUsersRecords(new Administrator().getNameModel());
		List<User> teachers = ServiceLocator.getDaoProvider()
				.getUsersRecords(new Teacher().getNameModel());
		List<User> students = ServiceLocator.getDaoProvider()
				.getUsersRecords(new Student().getNameModel());
		List<User> usersList = new ArrayList<User>();
		usersList.addAll(administrators);
		usersList.addAll(teachers);
		usersList.addAll(students);
		return usersList;
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser the type of user
	 * @return List<User> the list of users
	 */
	public List<User> getUsers(String typeUser) {
		List<User> records = 
				ServiceLocator.getDaoProvider().getUsersRecords(typeUser);
		return records;
	}
}
