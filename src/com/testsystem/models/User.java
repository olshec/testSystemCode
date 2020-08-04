package com.testsystem.models;

import com.testsystem.controller.ServerController;

/**
 * Represents an user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class User extends Model {

	public static final String nameModel = "User";

	private String firstName;
	private String lastName;
	private ServerController server;
	private String username;
	private String password;
	private int id;

	/** variable for increment id */
	private static int idCount;

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
	 * @param lastName  the user’s last name
	 * @param firstName the user’s first name
	 * @param server    the user’s server
	 * @param username  the user’s username
	 * @param password  the user’s password
	 */
	public User(String lastName, String firstName, ServerController server, String username, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.server = server;
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
	 * Gets the user’s first name.
	 * 
	 * @return String return first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Gets the user’s last name.
	 * 
	 * @return String return last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Gets the user’s username.
	 * 
	 * @return String return username
	 */
	public String getUserName() {
		return this.username;
	}

	/**
	 * Gets the user’s password.
	 * 
	 * @return String return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the user’s id.
	 * 
	 * @return Integer return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the user’s server.
	 * 
	 * @return Server return server
	 */
	public ServerController getServer() {
		return this.server;
	}
	
	/**
	 * Returns the hash code.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Equals check.
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
