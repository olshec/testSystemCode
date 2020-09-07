package com.testsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.model.Administrator;
import com.testsystem.model.Student;
import com.testsystem.model.Teacher;
import com.testsystem.model.User;
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
	 * Gets new Administrator.
	 */
	public static Administrator getNewAdministrator(String lastName, 
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
				.getUsersRecords(Administrator.nameModel);
		List<User> teachers = ServiceLocator.getDaoProvider()
				.getUsersRecords(Teacher.nameModel);
		List<User> students = ServiceLocator.getDaoProvider()
				.getUsersRecords(Student.nameModel);
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
	 * @return List<Model> the list of students
	 */
//	public List<Model> getUsersByType(String typeUser) {
//		List<Model> masUserResult = new ArrayList<Model>();
//		List<Model> records = ServiceLocator.getDaoProvider().getRecords(typeUser);
//		for (int i = 0; i < records.size(); i++) {
//			String className = records.get(i).getNameModel();
//			if (className.equals(typeUser)) {
//				masUserResult.add(records.get(i));
//			}
//		}
//		return masUserResult;
//	}

//	public List<User> getStudents() {
//		List<User> records = 
//				ServiceLocator.getDaoProvider().getStudents(Student.nameModel);
//		return records;
//	}

	public List<User> getUsers(String typeUser) {
		List<User> records = 
				ServiceLocator.getDaoProvider().getUsersRecords(typeUser);
		return records;
	}
}
