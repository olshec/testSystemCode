package com.testsystem.DAO.Providers;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.DAO.Tables.UserTable;
import com.testsystem.models.User;

/**
 * Represents a provider to the database containing user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserTableProvider {
	
	private UserTable userTable;

	/**
	 * Creates a UserBaseController.
	 * 
	 * @param userBase the database containing user.
	 */
	public UserTableProvider(UserTable userBase) {
		setUserBase(userBase);
	}

	/**
	 * Gets new UserBase.
	 */
	public static UserTable getNewUserBase() {
		return new UserTable();
	}
	
	/**
	 * Gets user by login and password.
	 * 
	 * @param username 		the name of user
	 * @param password 		the password of user
	 * @return UserModel 	the user
	 */
	public User getUser(String username, String password) {
		List<User> users = userTable.getUsers();
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
		return userTable.getUsers();
	}

	/**
	 * Adds user.
	 * 
	 * @param user the user.
	 */
	public void addUser(User user) {
		userTable.getUsers().add(user);
	}

	/**
	 * Gets result: does the database have a user.
	 * 
	 * @return boolean Returns true if database contains user
	 */
	public boolean hasUser(User user) {
		List<User> users = userTable.getUsers();
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
	public UserTable getUserBase() {
		return userTable;
	}

	/**
	 * Sets database of user.
	 * 
	 * @param userTable the database of user
	 */
	public void setUserBase(UserTable userTable) {
		this.userTable = userTable;
	}

	/**
	 * Gets users by type.
	 * 
	 * @param typeUser 			the type of user
	 * @return List<UserModel> 	the list of students
	 */
	public List<User> getUsersByType(String typeUser) {
		List<User> masUserResult = new ArrayList<User>();
		for (int i = 0; i < userTable.getUsers().size(); i++) {
			String className = userTable.getUsers().get(i).getClass().getSimpleName();
			if (className.equals(typeUser)) {
				masUserResult.add(userTable.getUsers().get(i));
			}
		}
		return masUserResult;
	}
}
