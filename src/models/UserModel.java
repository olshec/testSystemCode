package models;

import controllers.ServerController;

/**
 * Represents an user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class UserModel {
	private String firstName;
	private String lastName;
	private ServerController server;
	private String username;
	private String password;
	private int id;
	/** variable for increment id
	 */
	private static int idCount;

	static {
		idCount = 0;
	}

	/** Creates an user.
	 * @param lastName The user’s last name.
	 * @param firstName The user’s first name.
	 * @param server The user’s server.
	 * @param username The user’s username.
	 * @param password The user’s password.
	*/
	public UserModel(String lastName, String firstName, ServerController server, String username, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.server = server;
		this.username = username;
		this.password = password;
		this.id = idCount;
		idCount++;
	}

	/** Gets the user’s first name.
	 * @return String return first name
	*/
	public String getFirstName() {
		return this.firstName;
	}

	/** Gets the user’s last name.
	 * @return String return last name
	*/
	public String getLastName() {
		return this.lastName;
	}

	/** Gets the user’s username.
	 * @return String return username
	*/
	public String getUserName() {
		return this.username;
	}

	/** Gets the user’s password.
	 * @return String return password
	*/
	public String getPassword() {
		return this.password;
	}

	/** Gets the user’s id.
	 * @return Integer return id
	*/
	public int getId() {
		return this.id;
	}

	/** Gets the user’s server.
	 * @return Server return server
	*/
	public ServerController getServer() {
		return this.server;
	}

	/** Function for opening menu.
	*/
	public abstract void openMenu();
}
