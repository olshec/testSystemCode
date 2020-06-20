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
public class UserBaseModel {
	private List<UserModel> users;

	
	public UserBaseModel() {
		users = new ArrayList<UserModel>();
	}

	/**
	 * @return the users
	 */
	public List<UserModel> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}




}
