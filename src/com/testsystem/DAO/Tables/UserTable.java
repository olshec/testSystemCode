package com.testsystem.DAO.Tables;

import java.util.ArrayList;
import java.util.List;

import com.testsystem.models.User;

/**
 * Represents a table user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserTable {
	
	private List<User> users;

	/**
	 * Creates a UserTable.
	 */
	public UserTable() {
		users = new ArrayList<User>();
	}

	/**
	 * Creates a UserTable.
	 * 
	 * @param users the list of User
	 */
	public UserTable(List<User> users) {
		setUsers(users);
	}

	/**
	 * Gets list of users.
	 * 
	 * @return the list users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Sets users.
	 * 
	 * @param users the list of users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
