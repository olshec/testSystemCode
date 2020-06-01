package lab_2;

/**
 * Represents an user.
 * 
 * @author Oleg Shestakov
 * @author olshec@gmail.com
 * @version 1.0
 */
public abstract class User {
	private String firstName;
	private String lastName;
	private Server server;
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
	public User(String lastName, String firstName, Server server, String username, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.server = server;
		this.username = username;
		this.password = password;
		this.id = idCount;
		idCount++;
	}

	/** Gets the user’s first name.
	 * @return A string representing the user’s first name
	*/
	public String getFirstName() {
		return this.firstName;
	}

	/** Gets the user’s last name.
	 * @return A string representing the user’s last name
	*/
	public String getLastName() {
		return this.lastName;
	}

	/** Gets the user’s username.
	 * @return A string representing the user’s username
	*/
	public String getUserName() {
		return this.username;
	}

	/** Gets the user’s password.
	 * @return A string representing the user’s password
	*/
	public String getPassword() {
		return this.password;
	}

	/** Gets the user’s id.
	 * @return A integer representing the user’s id
	*/
	public int getId() {
		return this.id;
	}

	/** Gets the user’s server.
	 * @return A Server representing the user’s server
	*/
	public Server getServer() {
		return this.server;
	}

	/** Function for opening menu.
	*/
	public abstract void openMenu();
}
