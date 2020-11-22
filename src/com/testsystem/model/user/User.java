package com.testsystem.model.user;

import com.testsystem.model.Model;

/**
 * Represents an user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class User extends Model {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int id;

	/** variable for increment id */
	private static int idCount;

	/**
	 * Initialize static variables
	 */
	static {
		idCount = 0;
	}

	/**
	 * Creates an User.
	 */
	public User() {}

	/**
	 * Creates an User.
	 * 
	 * @param String  the user’s last name
	 * @param String  the user’s first name
	 * @param String  the user’s username
	 * @param String  the user’s password
	 */
	public User(String lastName, String firstName, String username, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.password = password;
		this.id = idCount;
		idCount++;
	}
	
	/**
	 * Gets name of model.
	 * 
	 * @return String return name of model
	 */
	public String getNameModel() {
		return "User";
	}
	
	/**
	 * Returns the user’s first name.
	 * 
	 * @return String the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Returns the user’s last name.
	 * 
	 * @return String the last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Returns the user’s username.
	 * 
	 * @return String the username
	 */
	public String getUserName() {
		return this.username;
	}

	/**
	 * Returns the user’s password.
	 * 
	 * @return String the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the user’s id.
	 * 
	 * @return int the return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns the hash code.
	 * 
	 * @return int the hash code of User
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Сhecks equality of objects.
	 * 
	 * @param Object the user
	 * @return boolean the result of compare objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
