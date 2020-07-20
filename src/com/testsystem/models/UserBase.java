package com.testsystem.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a database user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public class UserBase {
	
	private List<User> users;

	/**
	 * Creates a UserBase.
	 */
	public UserBase() {
		users = new ArrayList<User>();
	}

	/**
	 * Creates a UserBase.
	 * 
	 * @param users the list of User
	 */
	public UserBase(List<User> users) {
		super();
		this.users = users;
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
