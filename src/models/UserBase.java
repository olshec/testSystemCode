package models;

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

	/**Creates a UserBaseModel.
	 */
	public UserBase() {
		users = new ArrayList<User>();
	}
	
	/**Creates a UserBaseModel.
	 * @param users
	 */
	public UserBase(List<User> users) {
		super();
		this.users = users;
	}


	/**
	 * @return the list users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}




}