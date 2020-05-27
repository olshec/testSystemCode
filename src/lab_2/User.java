package lab_2;

public abstract class User {
	private String firstName;
	private String lastName;
	private Server server;
	private String username;
	private String password;
	private int id;

	public User() {

	}

	public User(Server server) {
		this.server = server;
	}

	
	public User(String lastName, String firstName, Server server, String username, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.server = server;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public Server getServer() {
		return this.server;
	}

	public abstract void openMenu();
}
